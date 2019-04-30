package cn.wangbowen.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
DUP接受端（要确保端口开放！，接受如果乱码，要设置String格式）
 */
public class UDPReceive {
    public static void main(String[] args) throws IOException {
        // 1.建立接受数据包
        byte[] b = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        // 2.创建套接字对象(参数是端口号，发送端的数据包端口号必须是这个，不然接收不到)
        DatagramSocket socket = new DatagramSocket(8888);
        // 3.接受数据包（程序处于阻塞状态，等待数据）
        socket.receive(dp);
        // 4.拆包
        String ip = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        // 如果输出乱码，可以再加一个编码参数
        System.out.println(ip + ":" + port + "\n" + new String(b, 0, dp.getLength()));
        // 5.关闭资源
        socket.close();
    }
}
