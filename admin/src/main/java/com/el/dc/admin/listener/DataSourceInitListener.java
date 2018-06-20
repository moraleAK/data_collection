package com.el.dc.admin.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
@Deprecated
public class DataSourceInitListener implements ApplicationListener<ContextRefreshedEvent> {
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("############################################\n" +
                "###############################################################");
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            System.out.println("############################################\n" +
                    "###############################################################");
        }
    }

    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("############################################\n" +
                "###############################################################");
//        try {
//            SocketService.run();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("############################################\n" +
                "###############################################################");
    }
}
