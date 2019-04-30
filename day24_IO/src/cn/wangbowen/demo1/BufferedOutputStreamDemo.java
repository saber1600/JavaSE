package cn.wangbowen.demo1;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流的缓冲流
 *      参数：字节输出流
 */
public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        // 装饰者设计模式
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("buffer.txt"));
        // 和之前一样的输出（GBK编码）
        bos.write(97);
        byte[] b = "HelloWorld".getBytes();
        bos.write(b);
        bos.write(b, 0, 5);
        bos.close();
    }
}
