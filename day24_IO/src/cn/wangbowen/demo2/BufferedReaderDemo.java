package cn.wangbowen.demo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入流的缓冲流
 *      参数：Reader的超类，转换流
 *      方法：String readLine().文件末尾了，返回null对象
 *      扩展：行号计数器
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        int numberLine = 1;
        BufferedReader br = new BufferedReader(new FileReader("buffer2.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(numberLine++ + "  " + line);
        }
        br.close();
    }
}
