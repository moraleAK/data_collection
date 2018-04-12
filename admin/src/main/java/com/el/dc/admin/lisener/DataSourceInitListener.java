package com.el.dc.admin.lisener;

import com.el.dc.admin.init.SocketService;
import com.el.dc.api.common.HttpClientUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DataSourceInitListener implements ApplicationListener<ContextRefreshedEvent> {
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("############################################\n" +
                "###############################################################");
        if(contextRefreshedEvent.getApplicationContext().getParent() == null){
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

    public static void main(String[] args) {
        HttpClientUtils.sendHttpRequest("http://localhost:9001/dc/data_receive" ,"hhhhh");
    }
}
