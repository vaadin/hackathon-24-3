# Auto-translated Vaadin Components

Based on the new default I18N provider in Flow, I created subclasses of Vaadin components that translate themselves automatically based on the current UI locale. They also automatically update their translations when the UI locale changes.

Demo: https://vaadin-components-translations.fly.dev/

In the `translations` properties file you can add translations like this:
```properties
vaadin.datePicker.monthNames=Januar,Februar,März,April,Mai,Juni,Juli,August,September,Oktober,November,Dezember
vaadin.datePicker.firstDayOfWeek=1
vaadin.datePicker.today=Heute
```

Then just render a component like this:
```java
LocalizedDatePicker datePicker = new LocalizedDatePicker();
```
