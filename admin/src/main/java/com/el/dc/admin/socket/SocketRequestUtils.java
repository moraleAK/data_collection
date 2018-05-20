package com.el.dc.admin.socket;

import com.el.dc.admin.util.FileUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketRequestUtils {
    private static String requestIp;
    private static int requestPort;
    private static String charsetName = "utf-8";

    public SocketRequestUtils(String requestIp, int requestPort) {
        setRequestIp(requestIp);
        setRequestPort(requestPort);
    }

    public String send(String reqData) throws IOException {
        Socket socket = new Socket(
                //  new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("118.178.57.153",1080))
        );

        socket.connect(
                new InetSocketAddress(requestIp, requestPort)
        );

        socket.getOutputStream().write(reqData.toString().getBytes(charsetName));

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        socket.getOutputStream().write(FileUtils.fileRead("D:\\222.png"));
        socket.close();
//        com.el.dc.admin.socket.getOutputStream().flush();
//
//        InputStream in = com.el.dc.admin.socket.getInputStream();
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//        int i = -1;
//        while ((i = in.read()) != -1) {
//            byteArrayOutputStream.write(i);
//        }
//
//        com.el.dc.admin.socket.close();
//        return new String(byteArrayOutputStream.toByteArray(), charsetName);
        return "success";
    }

    public static String getRequestIp() {
        return requestIp;
    }

    public static void setRequestIp(String requestIp) {
        SocketRequestUtils.requestIp = requestIp;
    }

    public static int getRequestPort() {
        return requestPort;
    }

    public static void setRequestPort(int requestPort) {
        SocketRequestUtils.requestPort = requestPort;
    }
}
