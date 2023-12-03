package com.vaadin.krisshk243.views.map;

import com.vaadin.flow.router.AccessDeniedException;

public class MapViewDeniedException extends AccessDeniedException {
    private final String message;
    public MapViewDeniedException() {
        super();
        message = "You are not allowed to access this page";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
