package com.vaadin.krisshk243.views.admin;

import com.vaadin.flow.router.AccessDeniedException;

public class AdminPageException extends AccessDeniedException {
    private final String message;
    public AdminPageException() {
        super();
        message = "You are not allowed to access this page";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
