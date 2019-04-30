package cn.wangbowen.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;

/**
 * FileOutputStream 字节流
 *
 * 使用步骤：
 *      1.创建流子类的对象，绑定数据目的
 *      2.调用流对象的方法write写
 *      3.close释放资源
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("a.txt");
        // 流对象的方法write数据

        // 写字节（ASCII）
        fos.write(49);
        fos.write(48);
        fos.write(48);

        // 写字节数组
        byte[] b1 = {97, 98, 99, 100};
        // 这里使用BGK的默认编码写入的
        byte[] b2 = {-97, -98, 88};
        fos.write(b1);
        fos.write(b2);
        // 写一部分字节
        fos.write(b1, 1, 2);
        // 字符串简便形式
        fos.write("Hello".getBytes());

        // 释放资源
        fos.close();
    }
}
