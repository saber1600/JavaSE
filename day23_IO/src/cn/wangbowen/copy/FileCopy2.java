package cn.wangbowen.copy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流复制文件，只能文本文件
 */
public class FileCopy2 {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("c.txt");
            fw = new FileWriter("cCopy.txt");
            // 字符缓存数组,大小2KB，char是2B
            char[] cbuf = new char[1024];
            int len = 0;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
                fw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源，先开后关
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 嵌套关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
