package com.vaadin.krisshk243.views;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.krisshk243.views.admin.AdminView;
import com.vaadin.krisshk243.views.map.MapView;

public class MainLayout extends VerticalLayout implements RouterLayout {
    private final Tabs tabs;
    private final Tab home;
    private final Tab admin;
    private final Tab map;
    private Tab selectedTab;

    public MainLayout() {
        setSizeFull();
        tabs = new Tabs();
        tabs.addThemeVariants(TabsVariant.LUMO_CENTERED);
        home = new Tab(new RouterLink("Home", HomeView.class));
        admin = new Tab(new RouterLink("Admin", AdminView.class));

        map = new Tab(new RouterLink("Map", MapView.class));
        tabs.add(home, admin, map);

        add(tabs);

        setMinWidth("50%");
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        attachEvent.getUI().getPage().fetchCurrentURL(url -> {
            if (url.getPath().equals("/")) {
                selectedTab = home;
            } else if (url.getPath().equals("/admin")) {
                selectedTab = admin;
            } else if (url.getPath().equals("/map")) {
                selectedTab = map;
            }
            tabs.setSelectedTab(selectedTab);
        });
    }
}
