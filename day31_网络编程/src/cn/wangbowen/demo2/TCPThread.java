package cn.wangbowen.demo2;

import java.io.*;
import java.net.Socket;
import java.util.Random;

/*
接受图片线程
 */
public class TCPThread implements Runnable{
    // 用来存放接受到的Socket
    private Socket socket;

    public TCPThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 0.创建目录
            File file = new File("upload");
            if (!file.exists()) {
                file.mkdirs();
            }
            // 1.打开流对象
            InputStream sis = socket.getInputStream();
            OutputStream sos = socket.getOutputStream();
            // 图片命名
            String fileName = "JPG_" + System.currentTimeMillis() + new Random().nextInt(999999) + ".jpg";
            // 使用文件分隔符，适应不同系统
            FileOutputStream fos = new FileOutputStream(file + File.separator + fileName);

            // 2.传输数据
            byte[] data = new byte[1024];
            int len = 0;
            // read会导致线程阻塞，而客户端发送的文件内容不包括文件结束符，所以客户端socket要发送shutdown方法
            while ((len = sis.read(data)) != -1) {
                fos.write(data, 0, len);
            }

            // 3.回复客户端接受完成
            sos.write("文件上传成功".getBytes());
            System.out.println("接收文件 FROM " + socket.getInetAddress().getHostAddress());

            // 4.关闭资源
            fos.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
