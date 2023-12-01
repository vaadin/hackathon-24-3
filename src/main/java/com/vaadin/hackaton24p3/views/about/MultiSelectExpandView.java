package com.vaadin.hackaton24p3.views.about;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.hackaton24p3.views.MainLayout;
import jakarta.annotation.security.PermitAll;


@PageTitle("Multi select")
@Route(value = "multiselect", layout = MainLayout.class)
@PermitAll
public class MultiSelectExpandView extends VerticalLayout {

    public MultiSelectExpandView() {
        var paragraph = new Paragraph("Demonstrates whether multiselect can expand and collapse based on items around it.");


        var radioButtons = new RadioButtonGroup<String>();
        radioButtons.setLabel("Simple radio buttons");
        radioButtons.setItems("One", "Two", "Three", "Four", "Five");

        var multiSelect = new MultiSelectComboBox<String>();
        multiSelect.setLabel("Expanding multi-select");
        multiSelect.setMinWidth("200px");
        multiSelect.setAutoExpand(MultiSelectComboBox.AutoExpandMode.HORIZONTAL);
        multiSelect.setItems("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen");

        var textField = new TextField("Just some text");

        var button1 = new Button("One");
        var button2 = new Button("Two");
        var button3 = new Button("Three");
        var button4 = new Button("Four");
        var buttonToggle = new Button("Toggle buttons");
        buttonToggle.addClickListener(buttonClickEvent -> {
           button2.setVisible(!button2.isVisible());
           button3.setVisible(!button3.isVisible());
           button4.setVisible(!button4.isVisible());
        });


        var row = new HorizontalLayout(radioButtons, multiSelect, textField, button1, button2, button3, button4);
        row.setWidth("1200px");


        var multiSelect2 = new MultiSelectComboBox<String>();
        multiSelect2.setLabel("Expanding multi-select");
        multiSelect2.setAutoExpand(MultiSelectComboBox.AutoExpandMode.HORIZONTAL);
        multiSelect2.setItems("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen");
        var row2 = new HorizontalLayout(multiSelect2);
        row2.setWidth("600px");


        add(paragraph, row, buttonToggle, row2);

    }

}
