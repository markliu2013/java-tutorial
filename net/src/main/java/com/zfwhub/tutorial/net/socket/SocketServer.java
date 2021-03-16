package com.zfwhub.tutorial.net.socket;

import java.net.*;

public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = new Socket();
            while (true) {
                socket = serverSocket.accept();
                ServerThread thread = new ServerThread(socket);
                thread.start();
                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端，" + address.getHostAddress()+":"+socket.getPort());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
