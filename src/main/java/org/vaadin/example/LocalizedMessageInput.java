package org.vaadin.example;

import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageInputI18n;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

import static org.vaadin.example.TranslationUtils.*;

public class LocalizedMessageInput extends MessageInput implements LocaleChangeObserver {
    @Override
    public void localeChange(LocaleChangeEvent localeChangeEvent) {
        MessageInputI18n i18n = new MessageInputI18n();
        i18n.setMessage(translate(this, "vaadin.messageInput.message"));
        i18n.setSend(translate(this, "vaadin.messageInput.send"));
        setI18n(i18n);
    }
}
