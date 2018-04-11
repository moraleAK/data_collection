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
    @Autowired
    UserService userService;

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
            // server将一直等待连接的到来
            System.out.println("server将一直等待连接的到来");
            Socket socket = server.accept();
            // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            try {
                while ((len = inputStream.read(bytes)) != -1) {
                    //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                    sb.append(new String(bytes, 0, len, "UTF-8"));
                    userService.addUser(System.currentTimeMillis() + "", System.currentTimeMillis() + "");
                    System.out.println("get message from client: " + sb);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("get message from client: " + sb);
            inputStream.close();
            socket.close();
        }

        server.close();
    }
}
