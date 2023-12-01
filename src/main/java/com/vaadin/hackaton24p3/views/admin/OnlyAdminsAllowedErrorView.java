package com.vaadin.hackaton24p3.views.admin;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.server.HttpStatusCode;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hackaton24p3.views.MainLayout;

@ParentLayout(MainLayout.class)
@AnonymousAllowed
public class OnlyAdminsAllowedErrorView extends VerticalLayout implements HasErrorParameter<NotAdminException> {

    @Override
    public int setErrorParameter(BeforeEnterEvent event,
                                 ErrorParameter<NotAdminException> parameter) {
        add(new Paragraph("Sorry, only admins allowed in this view. "));
        return HttpStatusCode.UNAUTHORIZED.getCode();
    }
}