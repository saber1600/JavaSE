package cn.wangbowen.demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputStream 读取文件
 * 使用数组：
 *      int read(byte[] b); 起到缓冲作用
 *
 */
public class FileInputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        // 一般都是开1024大小或整数倍的数组
        byte[] b = new byte[1024];
        // 存放返回值，代表读取到了几个字节
        int len = 0;
        // -1代表文件结束
        while ((len = fis.read(b)) != -1) {
            // 使用String的字节数组构造函数，代表从off开始，长度len的字符串
            System.out.println(new String(b, 0, len));
        }
        // 关闭资源
        fis.close();

    }
}
