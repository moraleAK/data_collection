package com.el.dc.admin.init;

import org.springframework.beans.factory.annotation.Autowired;

import com.el.dc.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SocketService {

    public void start() throws IOException {
        System.out.println("____________________________");
        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("_________________________________________");
                run(); //使用另一个线程来执行该方法，会避免占用Tomcat的启动时间
                return "Collection Completed";
            }
        });
        System.out.println("****************************************");
        new Thread(task).start();
        ;
    }

    public  void run() throws IOException {
        // 监听指定的端口
        int port = 9991;
        ServerSocket server = new ServerSocket(port);
        boolean a = true;
        while (a) {
          Socket socket = server.accept();
          SocketThread socketThread = new SocketThread(socket);
        }

        server.close();
    }
}
