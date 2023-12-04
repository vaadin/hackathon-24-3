package org.vaadin.example;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends VerticalLayout implements RouterLayout {

    public MainLayout() {
        RouterLink routerLink1 = AutoI18nHelper.withI18nKey(new RouterLink(FieldTranslationView.class), "#nav.fields");
        RouterLink routerLink2 = AutoI18nHelper.withI18nKey(new RouterLink(DomTranslationView.class), "#nav.dom");
        add(new HorizontalLayout(routerLink1, routerLink2));
    }
}
