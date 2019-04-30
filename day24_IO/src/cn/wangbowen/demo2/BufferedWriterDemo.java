package cn.wangbowen.demo2;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流的缓冲流
 *      特有方法：newLine()
 *      构造参数：FileWriter,OutputStreamWriter
 */
public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        // 参数还可以是转换流
        BufferedWriter bw = new BufferedWriter(new FileWriter("buffer2.txt"));
        bw.write(100);
        bw.flush();

        bw.write("你好".toCharArray());
        // 特有的方法
        // 推荐使用newLine，因为不同操作系统，的换行不一样windows是\r\n,Linux是\n。现实跨平台
        bw.newLine();
        bw.flush();

        bw.write("大家好");
        bw.flush();

        bw.close();

    }
}
