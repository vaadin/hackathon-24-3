package org.vaadin.example;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Locale;

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
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "i18n-fields", layout = MainLayout.class)
public class FieldTranslationView extends VerticalLayout {

    private final Span span;

    @I18nKey("#button.changeLocale")
    private final Button button;
    private final Button button2;

    private final DatePicker datePicker;

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed
     *            bean.
     */
    public FieldTranslationView() {
        button = new Button("", event -> switchLocale());
        add(button);

        button2 = new Button("", event -> switchLocale());
        add(button2);

        span = new Span();
        datePicker = new DatePicker();

        add(span, datePicker, new DatePicker("Not Translated DatePicker"), new Span("Not Translated Span"));

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
}
