package cn.wangbowen.demo1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/*
UDP发送端
 */
public class UDPSend {
    public static void main(String[] args) throws IOException {
        // 1.建立数据包接受4个参数，【字节数组、长度、InetAddress对象、对方端口号】
        byte[] b = "你好啊".getBytes();
        InetAddress ia = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(b, b.length, ia, 8888);
        // 2.创建套接字对象(使用空参构造函数)
        DatagramSocket socket = new DatagramSocket();
        // 3.发送数据包(接受端要先开启，才能收到)
        socket.send(dp);
        // 4.关闭资源
        socket.close();
    }
}
