package org.vaadin.example;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class ServiceInitListener implements VaadinServiceInitListener {
    @Override
    public void serviceInit(ServiceInitEvent serviceInitEvent) {

        serviceInitEvent.getSource().addUIInitListener(uiInitEvent -> {
            AutoI18nHelper.init(uiInitEvent.getUI());
        });

    }
}
