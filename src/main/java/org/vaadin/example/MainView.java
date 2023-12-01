package org.vaadin.example;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.select.SelectVariant;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.Locale;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        UI.getCurrent().setLocale(Locale.ENGLISH);

        setWidthFull();
        setPadding(false);

        // Header
        H1 heading = new H1("Auto-translated Vaadin components");
        heading.addClassName(LumoUtility.FontSize.XLARGE);
        Select<LocaleOption> languageSelector = createLanguageSelector();
        HorizontalLayout headerLayout = new HorizontalLayout(heading, languageSelector);
        headerLayout.setWidthFull();
        headerLayout.getStyle().setMaxWidth("1080px");
        headerLayout.addClassNames(
                LumoUtility.JustifyContent.BETWEEN,
                LumoUtility.AlignItems.CENTER
                );
        Header header = new Header();
        header.addClassNames(
                LumoUtility.Display.FLEX,
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.Padding.Horizontal.MEDIUM,
                LumoUtility.Padding.Vertical.SMALL,
                LumoUtility.Background.CONTRAST_10,
                LumoUtility.BoxSizing.BORDER
        );
        header.setWidthFull();
        header.add(headerLayout);
        add(header);

        // Main
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setPadding(false);
        mainLayout.setWidthFull();
        mainLayout.getStyle().setMaxWidth("1080px");
        add(mainLayout);

        LocalizedDatePicker datePicker = new LocalizedDatePicker();
        datePicker.setLabel("DatePicker");
        mainLayout.add(datePicker);

        LocalizedLoginForm loginForm = new LocalizedLoginForm();
        mainLayout.add(loginForm);

        LocalizedUpload upload = new LocalizedUpload();
        upload.setAutoUpload(false);
        mainLayout.add(upload);

        LocalizedMessageInput messageInput = new LocalizedMessageInput();
        mainLayout.add(messageInput);

        Main main = new Main();
        main.setWidthFull();
        main.addClassNames(
                LumoUtility.Display.FLEX,
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.Padding.Horizontal.MEDIUM,
                LumoUtility.BoxSizing.BORDER
        );
        main.add(mainLayout);
        add(main);
    }

    private Select<LocaleOption> createLanguageSelector() {
        Select<LocaleOption> select = new Select<>();
        select.setLabel("Locale");
        select.addThemeVariants(SelectVariant.LUMO_SMALL);
        select.addClassName(LumoUtility.Padding.NONE);
        select.setItems(
                LocaleOption.ENGLISH,
                LocaleOption.FRENCH,
                LocaleOption.GERMAN,
                LocaleOption.SPANISH,
                LocaleOption.KLINGON
        );
        select.setValue(LocaleOption.ENGLISH);
        select.setItemLabelGenerator(LocaleOption::label);
        select.addValueChangeListener(event -> {
            this.getUI().ifPresent(ui -> ui.setLocale(event.getValue().locale()));
        });
        return select;
    }

    private record LocaleOption(Locale locale, String label) {
        private static final LocaleOption ENGLISH = new LocaleOption(Locale.ENGLISH, "\uD83C\uDDEC\uD83C\uDDE7 English");
        private static final LocaleOption FRENCH = new LocaleOption(Locale.FRENCH, "\uD83C\uDDEB\uD83C\uDDF7 Français");
        private static final LocaleOption GERMAN = new LocaleOption(Locale.GERMAN, "\uD83C\uDDE9\uD83C\uDDEA Deutsch");
        private static final LocaleOption SPANISH = new LocaleOption(Locale.forLanguageTag("es"), "\uD83C\uDDEA\uD83C\uDDF8 Español");
        private static final LocaleOption KLINGON = new LocaleOption(Locale.forLanguageTag("klingon"), "\uD83D\uDD96 Klingon");
    }
}
