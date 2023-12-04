package org.vaadin.example;

import java.lang.annotation.*;

/**
 * When used on a field, this will define a specific translation key to use instead of the field name. Starting
 * the value with a hashtag will interprete the given value as an absolute / global path and to ignore the
 * parent prefix.
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface I18nKey {
    String value();

}
