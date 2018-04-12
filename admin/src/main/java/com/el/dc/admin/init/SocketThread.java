package com.el.dc.admin.init;

import com.el.dc.api.common.HttpClientUtils;
import com.el.dc.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

@Transactional
public class SocketThread extends Thread{
    private Socket socket;
    public SocketThread(Socket client) {
        socket = client;
        new Thread(this).start();
    }
    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        try {
            while ((len = inputStream.read(bytes)) != -1) {
                //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                sb.append(new String(bytes, 0, len, "UTF-8"));
                HttpClientUtils.sendHttpRequest("http://localhost:9001/dc/data_receive"
                        ,new String(bytes, 0, len, "UTF-8"));
                //userService.addUser(System.currentTimeMillis() + "", System.currentTimeMillis() + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("get message from client: " + sb);
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
