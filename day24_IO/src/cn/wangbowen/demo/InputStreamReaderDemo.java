package cn.wangbowen.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符输入转换流
 *      参数：所有字节输入流，字符编码
 *      说明：将字节转为字符（char）的桥梁
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        readBGK();
        readUTF();
    }

    /*
    采用BGK读取
     */
    public static void readBGK() throws IOException {
        // 字节输入流
        FileInputStream fis1 = new FileInputStream("bgk.txt");
        FileInputStream fis2 = new FileInputStream("utf.txt");
        // 转换流对象
        InputStreamReader isr1 = new InputStreamReader(fis1, "GBK");
        char[] cbuf = new char[1024];
        int len = isr1.read(cbuf);
        System.out.println("采用BGK编码，读取bgk：" + new String(cbuf, 0, len));
        isr1.close();

        InputStreamReader isr2 = new InputStreamReader(fis2, "GBK");
        len = isr2.read(cbuf);
        System.out.println("采用BGK编码，读取utf-8：" + new String(cbuf, 0, len));
        isr2.close();
    }

    /*
    采用UTF-8读取
     */
    public static void readUTF() throws IOException {
        // 字节输入流
        FileInputStream fis1 = new FileInputStream("bgk.txt");
        FileInputStream fis2 = new FileInputStream("utf.txt");
        // 转换流对象
        InputStreamReader isr1 = new InputStreamReader(fis1, "UTF-8");
        char[] cbuf = new char[1024];
        int len = isr1.read(cbuf);
        System.out.println("采用UTF-8编码，读取bgk：" + new String(cbuf, 0, len));
        isr1.close();

        InputStreamReader isr2 = new InputStreamReader(fis2, "UTF-8");
        len = isr2.read(cbuf);
        System.out.println("采用UTF-8编码，读取utf-8：" + new String(cbuf, 0, len));
        isr2.close();
    }
}
