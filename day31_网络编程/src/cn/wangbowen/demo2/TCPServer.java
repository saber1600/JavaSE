package cn.wangbowen.demo2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
TCP服务器端(多线程模式)
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        // 1.创建服务器Socket(参数只要端口)
        ServerSocket serverSocket = new ServerSocket(2222);
        System.out.println("服务器开启成功！");
        // 2.开启监听
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new TCPThread(socket)).start();
        }
    }
}
