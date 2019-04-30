package cn.wangbowen.demo2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Write 所有字符输出流的超类
 *      限制：只能文本文件输出
 *      方法：就是字节的byte变成char
 *
 *
 */
public class WriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("c.txt");
        // 写一个字符
        fw.write('a');
        // 每次写完记得刷新下
        fw.flush();

        // 写字符数组
        char[] chars = {'1', '2', '3', '4'};
        fw.write(chars);
        fw.flush();

        // 写部分字符数组
        fw.write(chars, 1, 2);
        fw.flush();

        // 写字符串
        fw.write("Hello");
        fw.flush();

        // 关闭资源
        fw.close();

    }
}
