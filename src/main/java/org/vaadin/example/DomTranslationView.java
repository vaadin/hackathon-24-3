package org.vaadin.example;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.Locale;

import static org.vaadin.example.AutoI18nHelper.withI18nKey;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route(value = "i18n-dom", layout = MainLayout.class)
@I18nKey("i18n-dom")
public class DomTranslationView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed
     *            bean.
     */
    public DomTranslationView() {
        Button button = withI18nKey(new Button(), "#button.changeLocale");
        button.addClickListener(event -> switchLocale());
        add(button);

        VerticalLayout layout = new VerticalLayout();
        withI18nKey(layout, "form");

        layout.add(withI18nKey(new TextField(), "name"));
        layout.add(withI18nKey(new DatePicker(), "birthday"));
        layout.add(withI18nKey(new ComboBox<>(), "gender"));
        layout.add(new TextField("not translated"));
        layout.add(new SomeSubForm());
        layout.add(withI18nKey(new Button(), "#button.submit"));
        add(layout);
    }

    private void switchLocale() {
        UI ui = UI.getCurrent();
        Locale locale = ui.getLocale();
        if (Locale.GERMAN.equals(locale)) {
            ui.setLocale(Locale.ENGLISH);
        } else {
            ui.setLocale(Locale.GERMAN);
        }
    }

    private static final class SomeSubForm extends VerticalLayout {
        public SomeSubForm() {
            withI18nKey(this, "address");
            add(withI18nKey(new TextField(), "street"));
            add(withI18nKey(new TextField(), "number"));
            add(withI18nKey(new TextField(), "city"));
        }
    }

}
