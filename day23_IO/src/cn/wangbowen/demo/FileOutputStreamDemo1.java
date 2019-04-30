package cn.wangbowen.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream 文件追加
 */
public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("a.txt");
        FileOutputStream fos = new FileOutputStream(file, true);
        // 换行
        fos.write("\r\n".getBytes());
        fos.write("Hello".getBytes());

        fos.close();
    }
}
