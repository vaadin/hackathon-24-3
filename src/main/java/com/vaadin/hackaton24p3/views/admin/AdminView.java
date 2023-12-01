package com.vaadin.hackaton24p3.views.admin;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AccessDeniedErrorRouter;
import com.vaadin.hackaton24p3.views.MainLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "admin", layout = MainLayout.class)
@RolesAllowed("ADMIN")
@AccessDeniedErrorRouter(rerouteToError = NotAdminException.class)
public class AdminView extends VerticalLayout {
    public AdminView() {
        var paragraph = new Paragraph("This is the Admin view, only admins can access it.");

        add(paragraph);
    }
}
