package org.vaadin.example;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.data.binder.Setter;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import static com.vaadin.flow.component.datepicker.DatePicker.DatePickerI18n;

/**
 * Takes care of automatically translating routed components' fields and/or any attached components with a specific key.
 * Fields / components must implement either HasLabel or HasText (HasLabel has priority in setting the translation).
 * <p/>
 * <b>Field translation</b><br>
 * A routed class will be scanned for fields. For a field, it will try to apply the
 * routed components class name plus the field name (e.g. MainView#someComponent -> "mainView.someComponent").
 * <p/>
 * <b>Child / component translation</b>
 * All children of the ui will be scanned for translation keys ({@link AutoI18nHelper#withI18nKey(Component, String)}.
 * If the component has a key, the tool tries to build up a path and apply the translation. Any parent translation
 * key will be applied to the path, even if that parent is not a label / text holder. The routed class will be the
 * first part and has the same pattern as for the field translation (e.g. "mainView"). You can for instance apply
 * a i18n key to a vertical layout to add an extra layer (global keys will be ignored for this case)
 * If a field component is setup with a i18n key, the i18n key is applied, even if the field itself is marked to be
 * ignored.
 * <p/>
 * <b>Global keys</b><br>
 * To create a global key (e.g. to prevent repetitive definitions of global words like submit or update), you
 * can prefix an i18n key with "#". These keys will be taken as absolute keys from the translation properties without
 * any additional prefixes. Works with the annotation {@link I18nKey} and the method {@link #withI18nKey(Component, String)}.
 * Please note, that global keys are not added to the full path of child components.
 * <p/>
 * <b>Automatic translation</b><br>
 * DatePicker I18n will be interpreted automatically on a global level. You can set the following translations to
 * your properties and they will be applied to all DatePickers and DateTimePickers, if they are not part of an ignored
 * component:
 * <ul>
 * <li>datePicker.cancel</li>
 * <li>datePicker.today</li>
 * <li>datePicker.primaryDateFormat</li>
 * <li>datePicker.additionalDateFormats (comma separated list)</li>
 * <li>datePicker.weekdays (comma separated list)</li>
 * <li>datePicker.weekdaysShort (comma separated list)</li>
 * <li>datePicker.firstDayOfWeek (Integer)</li>
 * </ul>
 * <p/>
 * <b>Page title</b><br>
 * If the routed class is neither annotated with {@link PageTitle} nor implemends the {@link HasDynamicTitle} interface,
 * the title will be set based on the routed component translation key (e.g. "mainView=Hello World View").
 * If there is a translation, it will be set as the page title, otherwise the page title is kept unchanged.
 * <p/>
 * <b>Ignore</b><br>
 * Use the {@link I18nIgnore} on the routed class or any field to ignore the translation for the target.
 * <p/>
 *
 * <b>Install</b>
 * Call {@link AutoI18nHelper#init(UI)} in the ui init listener of your service init listener.
 *
 */
@Tag("vaadin-locale-handler")
public class AutoI18nHelper extends Component //needed to have the locale change observer running
        implements LocaleChangeObserver {

    private AutoI18nHelper() {
    }

    public static AutoI18nHelper init(UI ui) {
        AutoI18nHelper instance = new AutoI18nHelper();
        ui.addAfterNavigationListener(event -> {
            if (!instance.isAttached()) {
                ui.getElement().appendVirtualChild(instance.getElement());
            } else {
                instance.localeChange(new LocaleChangeEvent(ui, ui.getLocale()));
            }
        });

        return instance;
    }

    @Override
    public void localeChange(LocaleChangeEvent localeChangeEvent) {
        UI ui = localeChangeEvent.getUI();
        iterateChildren(ui.getChildren(), ui, "");
    }

    private void iterateChildren(Stream<Component> children, UI ui, String parentKey) {
        System.out.println("iterate for path: " + parentKey);
        children.forEach(component -> {
            Class<? extends Component> componentClass = component.getClass();

            if (!componentClass.isAnnotationPresent(I18nIgnore.class)) {
                String key = null;

                if (component instanceof DatePicker c) {
                    c.setI18n(createDatePickerI18n());
                } else if (component instanceof DateTimePicker c) {
                    c.setDatePickerI18n(createDatePickerI18n());
                }


                if (componentClass.isAnnotationPresent(Route.class)) {
                    // we are in a routed view class, so we check it for components and try to match that with
                    // some translation strings.
                    // TBD: go deeper in the hierarchy and concatenate paths?

                    String path = null;
                    if (componentClass.isAnnotationPresent(I18nKey.class)) {
                        path = componentClass.getAnnotation(I18nKey.class).value();
                    } else {
                        String simpleName = componentClass.getSimpleName();
                        simpleName = simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);
                        path = simpleName;
                    }
                    key = path;

                    if (!componentClass.isAnnotationPresent(PageTitle.class) && !(component instanceof HasDynamicTitle)) {
                        getTranslationIfDefined(key).ifPresent(s -> setPageTitle(ui, s));
                    }

                    Field[] fields = componentClass.getDeclaredFields();
                    for (Field field : fields) {
                        if (!field.isAnnotationPresent(I18nIgnore.class)) {
                            Class<?> fieldType = field.getType();

                            boolean hasLabel = HasLabel.class.isAssignableFrom(fieldType);
                            boolean hasText = HasText.class.isAssignableFrom(fieldType);

                            if (hasLabel || hasText) {
                                String name = field.getName();

                                String componentPath = path;
                                if (field.isAnnotationPresent(I18nKey.class)) {
                                    String value = field.getAnnotation(I18nKey.class).value();
                                    if (isGlobalKey(value)) {
                                        componentPath = parseGlobalKey(value);
                                    } else {
                                        componentPath += "." + value;
                                    }

                                } else {
                                    componentPath += "." + name;
                                }

                                String translation = getTranslation(componentPath);
                                Setter<Object, String> i18nSetter;
                                if (hasLabel) {
                                    i18nSetter = (o, str) -> ((HasLabel) o).setLabel(str);
                                } else {
                                    i18nSetter = (o, str) -> ((HasText) o).setText(str);
                                }

                                try {
                                    Object fieldValue = FieldUtils.readDeclaredField(component, name, true);
                                    i18nSetter.accept(fieldValue, translation);
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                        }
                    }
                } else {
                    String translationKey = getTranslationKey(component);
                    if (StringUtils.isNotBlank(translationKey)) {

                        if (isGlobalKey(translationKey)) {
                            translationKey = parseGlobalKey(translationKey);
                        } else {
                            translationKey = StringUtils.isNotBlank(parentKey) ? parentKey + "." + translationKey : translationKey;
                            key = translationKey;
                        }

                        Setter<Object, String> i18nSetter = null;
                        if (component instanceof HasLabel) {
                            i18nSetter = (o, str) -> ((HasLabel) o).setLabel(str);
                        } else if (component instanceof HasText) {
                            i18nSetter = (o, str) -> ((HasText) o).setText(str);
                        }

                        if (i18nSetter != null) {
                            String translation = getTranslation(translationKey);
                            i18nSetter.accept(component, translation);
                        }
                    }
                }

                iterateChildren(component.getChildren(), ui, key == null ? parentKey : key);
            }
        });
    }

    private static void setPageTitle(UI ui, String translation) {
        ui.getElement().executeJs("document.title = $0", translation);
    }

    private DatePickerI18n createDatePickerI18n() {
        DatePickerI18n i18n = new DatePickerI18n();

        setIfDefined(i18n, "datePicker.cancel", DatePickerI18n::setCancel);
        setIfDefined(i18n, "datePicker.today", DatePickerI18n::setToday);

        getTranslationStringArrayIfDefined("datePicker.monthNames", ",")
                .filter(a -> a.length == 12)
                .map(Arrays::asList)
                .ifPresent(i18n::setMonthNames);

        getTranslationStringArrayIfDefined("datePicker.weekdays", ",")
                .filter(a -> a.length == 7)
                .map(Arrays::asList)
                .ifPresent(i18n::setWeekdays);

        getTranslationStringArrayIfDefined("datePicker.weekdaysShort", ",")
                .filter(a -> a.length == 7)
                .map(Arrays::asList)
                .ifPresent(i18n::setWeekdaysShort);

        getTranslationIfDefined("datePicker.firstDayOfWeek")
                .filter(NumberUtils::isCreatable)
                .map(Integer::valueOf)
                .ifPresent(i18n::setFirstDayOfWeek);

        getTranslationIfDefined("datePicker.primaryDateFormat")
                .ifPresent(s -> i18n.setDateFormats(s,
                        getTranslationStringArrayIfDefined("datePicker.additionalDateFormats", ",")
                                .orElseGet(() -> new String[0])));


        return i18n;
    }

    private <T> void setIfDefined(T target, String key, Setter<T, String> setter) {
        String translation = getTranslation(key);
        if (!translation.startsWith("!")) {
            setter.accept(target, translation);
        }
    }

    private Optional<String> getTranslationIfDefined(String key) {
        return Optional.of(getTranslation(key)).filter(s -> !s.startsWith("!"));
    }

    private Optional<String[]> getTranslationStringArrayIfDefined(String key, String splitter) {
        return getTranslationIfDefined(key).map(s -> s.split(splitter));
    }

    private static boolean isGlobalKey(String key) {
        return key != null && key.startsWith("#");
    }

    private static String parseGlobalKey(String key) {
        return key != null ? key.substring(1) : null;
    }

    public static <T extends Component> T withI18nKey(T component, String key) {
        ComponentUtil.setData(component, "translationId", key);
        return component;
    }

    public static String getTranslationKey(Component component) {
        return (String) ComponentUtil.getData(component, "translationId");
    }
}
