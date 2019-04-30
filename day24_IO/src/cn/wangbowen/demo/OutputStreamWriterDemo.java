package cn.wangbowen.demo;

import java.io.*;

/**
 * 字符输出转换流
 *      参数：接受一个字节流对象，和字符编码
 *      说明：是字符(程序char)转字节(文件byte)的桥梁
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        writeGBK();
        writeUTF();
    }

    /*
    文本采用BGK
     */
    public static void writeGBK() throws IOException {
        // 创建一个字节流
        FileOutputStream fos = new FileOutputStream("bgk.txt");
        // 创建一个字符转换流，如果参数只有一个字节流对象，编码默认是本地编码.但是这里IDEA设置是UTF-8所以，要手动写上GBK
        OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
        // 输出文字(GBK一个汉字2字节)
        osw.write("你好");
        osw.flush();

        osw.close();
    }

    /*
    文本采用UTF-8
     */
    public static void writeUTF() throws IOException {
        // 创建一个字节流
        FileOutputStream fos = new FileOutputStream("utf.txt");
        // 创建一个字符转换流，如果参数只有一个字节流对象，编码默认是本地编码.但是这里IDEA设置是UTF-8所以，要手动写上GBK
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        // 输出文字(UTF-8一个汉字3字节)
        osw.write("你好");
        osw.flush();

        osw.close();
    }
}
