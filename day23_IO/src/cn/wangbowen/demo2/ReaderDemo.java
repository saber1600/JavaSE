package cn.wangbowen.demo2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reader 所有字符输入流的超类
 *  局限：只能处理文本文件
 *  优点：中英文不会乱码
 */
public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("c.txt");
        // 单个字符
        /*int len = 0;
        while ((len = fr.read()) != -1) {
            System.out.print((char) len);
        }*/

        // 字符数组
        char[] chars = new char[1024];
        int len = 0;
        while ((len = fr.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }

        // 关闭资源
        fr.close();
    }
}
