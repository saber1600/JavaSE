package cn.wangbowen.copy;

import java.io.*;

/**
 * 文件拷贝使用缓冲流
 *      要么用字节流的数组拷贝，要么用缓冲流，其他单个字节的复制不推荐
 */
public class BufferedCopy {
    public static void main(String[] args) {
        copyByBufferedIOStream(new File("buffer.txt"), new File("bufferCopy.txt"));
    }
    /*
    字节缓冲流拷贝
     */
    public static void copyByBufferedIOStream(File src, File dest) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(dest));

            byte[] b = new byte[1024];
            int len = 0;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
