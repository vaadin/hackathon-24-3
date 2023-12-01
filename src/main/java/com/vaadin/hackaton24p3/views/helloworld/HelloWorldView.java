package com.vaadin.hackaton24p3.views.helloworld;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.hackaton24p3.views.MainLayout;
import com.vaadin.hackaton24p3.views.admin.AdminView;
import jakarta.annotation.security.PermitAll;

@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PermitAll
public class HelloWorldView extends VerticalLayout {



    public HelloWorldView() {
        var paragraph = new Paragraph("You might want to click this link to go to the admin view. " +
                "But if you don't have access, you might get access denied page.");

        var goToAdminViewLink = new RouterLink(AdminView.class);
        goToAdminViewLink.setText("Admin View");
        add(paragraph, goToAdminViewLink);
    }

}
