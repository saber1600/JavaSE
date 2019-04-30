package cn.wangbowen.copy;

import java.io.*;

/**
 * 字符缓冲流复制文本
 */
public class BufferedCopy2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("buffer2.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("buffer2Copy.txt"));
        String line = null;
        boolean isend = true;
        while ((line = br.readLine()) != null) {
            // 这里有个问题，就是最后一行后，会多一个空行。可以对程序进行改进。
            /*bw.write(line);
            bw.newLine();
            bw.flush();*/
            if (!isend) {
                bw.newLine();
            }
            bw.write(line);
            bw.flush();
            if ((line = br.readLine()) != null) {
                bw.newLine();
                bw.write(line);
                bw.flush();
                isend = false;
            }
        }
        bw.close();
        br.close();

    }
}
