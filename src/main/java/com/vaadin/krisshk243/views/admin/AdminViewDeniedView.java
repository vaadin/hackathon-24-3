package com.vaadin.krisshk243.views.admin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.krisshk243.security.AuthenticatedUser;
import com.vaadin.krisshk243.services.AdminService;
import com.vaadin.krisshk243.views.MainLayout;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "/denied", layout = MainLayout.class)
@RolesAllowed("ROLE_USER")
public class AdminViewDeniedView extends VerticalLayout implements HasErrorParameter<AdminPageException> {

    public AdminViewDeniedView(@Autowired AdminService adminService, AuthenticatedUser autorisedUser) {
        add("Get Admin role here:");
        Button backButton = new Button("FREE ADMIN FOR YOU", e -> {
            adminService.addAdminRoleToUser(autorisedUser);
        });
        add(backButton);
        Button backToMain = new Button("Go to admin page", e -> {
            getUI().ifPresent(ui -> ui.navigate("admin"));
        });
        add(backToMain);
    }

    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<AdminPageException> parameter) {
        event.getUI().access(() -> {
            Notification notification = new Notification("Oopsie, you didn't have admin role", 3000, Notification.Position.MIDDLE);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            notification.open();
        });
        return 200;
    }
}
