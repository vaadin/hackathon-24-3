package com.vaadin.krisshk243.views.map;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AccessDeniedErrorRouter;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.krisshk243.views.MainLayout;

@AnonymousAllowed
@Route(value = "map-view-denied", layout = MainLayout.class)
@AccessDeniedErrorRouter(rerouteToError = MapViewDeniedException.class)
public class MapViewDeniedView extends VerticalLayout  implements HasErrorParameter<MapViewDeniedException> {

    public MapViewDeniedView() {
        add("Try your luck in different place:");
        Button backToMain = new Button("Go to admin page", e ->
                getUI().ifPresent(ui -> ui.navigate("admin")));
        add(backToMain);
    }
    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<MapViewDeniedException> parameter) {
        event.getUI().access(() -> {
            Notification notification = new Notification("Maps are only for chosen few", 3000, Notification.Position.MIDDLE);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            notification.open();
        });
        return 404;
    }
}
