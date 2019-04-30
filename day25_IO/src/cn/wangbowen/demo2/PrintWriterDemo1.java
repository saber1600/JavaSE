package cn.wangbowen.demo2;

import java.io.*;

/**
 * 打印流文本复制
 * 因为，打印流不管数据源，所以读取数据要用BufferReader
 */
public class PrintWriterDemo1 {
    public static void main(String[] args) throws IOException {
        // 因为源文件是GBK编码，最终输出也要是GBK，编译器是采用UTF-8的形式，所以运用转换流
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("print_6.txt"), "GBK"));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("print_6Copy.txt"),
                "GBK"), true);
        String line = null;
        while ((line = br.readLine()) != null) {
            pw.println(line);
        }
        pw.close();
        br.close();
    }
}
