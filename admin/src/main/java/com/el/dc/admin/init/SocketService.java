package com.el.dc.admin.init;

import com.el.dc.admin.netty.DataCollectionService;
import com.el.dc.admin.properties.MyProperties;
import com.el.dc.admin.properties.MyPropertyPlaceholderConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SocketService {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    public void start() throws IOException {
        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("_________________________________________");
//                run(); //使用另一个线程来执行该方法，会避免占用Tomcat的启动时间
                new DataCollectionService(
                        Integer.valueOf(MyPropertyPlaceholderConfigurer.getPropertiesMap().get(MyProperties.DC_SOCKET_PORT))
                ).start();
                LOG.info("Collection Completed");
                return "Collection Completed";
            }
        });
        new Thread(task).start();
        LOG.info("socket listener start!");
    }

    public  void run() throws IOException {
        // 监听指定的端口
        int port = Integer.valueOf(MyPropertyPlaceholderConfigurer.getPropertiesMap().get(MyProperties.DC_SOCKET_PORT));
        ServerSocket server = new ServerSocket(port);
        boolean a = true;
        while (a) {
          Socket socket = server.accept();
          SocketThread socketThread = new SocketThread(socket);
        }
        server.close();
    }
}
