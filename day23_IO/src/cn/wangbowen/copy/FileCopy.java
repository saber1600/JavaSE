package cn.wangbowen.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制
 */
public class FileCopy {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 打开数据源和目的
            fis = new FileInputStream("utf.txt");
            fos = new FileOutputStream("cCopy.txt");
            // 利用数组缓冲加速拷贝
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = fis.read(b)) != -1) {
                System.out.println(new String(b, 0, len));
                fos.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源(先开后关)
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 嵌套关闭资源
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/*
jdk7的新写法
    在jdk7中新加入了AutoCloseable接口，IO流中的类都实现了这个接口，这样在读取或者写出操作结束之后，系统会自动close相关资源，
开发者不需要再手动close了
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO7Style {

    public static void main(String[] args) {
        // 变量写在try()里面
        try (FileInputStream fis = new FileInputStream("monkey.txt");
             FileOutputStream fos = new FileOutputStream("rabbit.txt");) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

*/
