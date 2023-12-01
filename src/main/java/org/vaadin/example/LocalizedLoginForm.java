package org.vaadin.example;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

import static org.vaadin.example.TranslationUtils.*;

public class LocalizedLoginForm extends LoginForm implements LocaleChangeObserver {
    @Override
    public void localeChange(LocaleChangeEvent localeChangeEvent) {
        LoginI18n i18n = LoginI18n.createDefault();
        i18n.getForm().setTitle(translate(this, "vaadin.login.form.title"));
        i18n.getForm().setUsername(translate(this, "vaadin.login.form.username"));
        i18n.getForm().setPassword(translate(this, "vaadin.login.form.password"));
        i18n.getForm().setSubmit(translate(this, "vaadin.login.form.submit"));
        i18n.getForm().setForgotPassword(translate(this, "vaadin.login.form.forgotPassword"));

        i18n.getErrorMessage().setTitle(translate(this, "vaadin.login.error.title"));
        i18n.getErrorMessage().setMessage(translate(this, "vaadin.login.error.message"));
        i18n.getErrorMessage().setUsername(translate(this, "vaadin.login.error.username"));
        i18n.getErrorMessage().setPassword(translate(this, "vaadin.login.error.password"));

        setI18n(i18n);
    }
}
