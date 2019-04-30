package cn.wangbowen.demo2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
TCP传输图片
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        // 1.创建套接字(new即连接，所以参数是IP和端口)
        Socket socket = new Socket("127.0.0.1", 2222);
        // 2.创建本地文件流，和socket发送流、接受流
        InputStream sis = socket.getInputStream();
        OutputStream sos = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("Photo_TCP.jpg");
        // 3.传送文件
        byte[] data = new byte[1024];
        int len = 0;
        while ((len = fis.read(data)) != -1) {
            sos.write(data, 0, len);
        }
        // 4.给服务器发送中止序列，告知服务器内容已经传送完成
        socket.shutdownOutput();
        // 5.等待服务器返回的信息
        len = sis.read(data);
        System.out.println("服务返回内容：" + new String(data, 0, len));
        // 6.关闭资源
        fis.close();
        socket.close();
    }
}
