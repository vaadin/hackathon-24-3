package org.vaadin.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the type or field to be ignored for automatic i18n translation. On a type all fields or children will
 * be ignored. On a field, this field will be ignored. Also any settings for date picker etc will be ignored
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface I18nIgnore {
}
