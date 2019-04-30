package cn.wangbowen.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO流的异常处理
 * try catch finally
 */
public class FileOutputStreamDemo2 {
    public static void main(String[] args) {
        // try外面申明变量
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("a.txt");
            fos.write(100);
        } catch (IOException e) {
            // 知道哪里出问题了，比如U盘中途拔掉了
            e.printStackTrace();
            // IO异常一般不做处理（如外设）
            // 所以，先报错，停下程序，然后重新尝试
        } finally {
            // 为关闭资源再写一个try
            try {
                // 只有对象创建成功才关闭
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
