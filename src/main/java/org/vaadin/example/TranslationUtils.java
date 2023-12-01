package org.vaadin.example;

import com.vaadin.flow.component.Component;

import java.util.Arrays;
import java.util.List;

public class TranslationUtils {
    public static String translate(Component component, String key) {
        String value = component.getTranslation(key);
        if (value == null || value.isEmpty()) {
            return null;
        }
        return value;
    }

    public static int translateInt(Component component, String key) {
        String value = component.getTranslation(key);
        if (value == null || value.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    public static List<String> translateList(Component component, String key) {
        String value = component.getTranslation(key);
        if (value == null || value.isEmpty()) {
            return null;
        }
        return Arrays.stream(value.split(",")).toList();
    }
}
