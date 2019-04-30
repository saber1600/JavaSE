package cn.wangbowen.demo1;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节输入流的转换流
 */
public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("buffer.txt"));
        byte[] b = new byte[10];
        int len = 0;
        while ((len = bis.read(b)) != -1) {
            System.out.print(new String(b, 0, len));
        }
        bis.close();
        System.out.println("\n注意：inputStream这里默认是使用UTF-8的，所以读入BGK编码的中文时候会出错。试试bgk.txt");
    }
}
