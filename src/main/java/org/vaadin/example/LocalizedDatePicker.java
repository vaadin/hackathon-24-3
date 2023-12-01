package org.vaadin.example;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

import static org.vaadin.example.TranslationUtils.*;

public class LocalizedDatePicker extends DatePicker implements LocaleChangeObserver {
    @Override
    public void localeChange(LocaleChangeEvent localeChangeEvent) {
        DatePicker.DatePickerI18n i18n = getI18n();
        if (i18n == null) {
            i18n = new DatePicker.DatePickerI18n();
        }
        i18n.setMonthNames(translateList(this, "vaadin.datePicker.monthNames"));
        i18n.setWeekdays(translateList(this, "vaadin.datePicker.weekdays"));
        i18n.setWeekdaysShort(translateList(this, "vaadin.datePicker.weekdaysShort"));
        i18n.setFirstDayOfWeek(translateInt(this, "vaadin.datePicker.firstDayOfWeek"));
        i18n.setToday(translate(this, "vaadin.datePicker.today"));
        i18n.setCancel(translate(this, "vaadin.datePicker.cancel"));

        setI18n(i18n);
    }
}
