package cn.wangbowen.demo3;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonsIODemo1 {
    public static void main(String[] args) throws IOException {
        fun_1();
        fun_2();
        fun_3();
        fun_4();
    }

    /*
    FileUtils工具类
    读取文件
    static String readFileToString(File src)
     */
    public static void fun_1() throws IOException {
        String s = FileUtils.readFileToString(new File("bgk.txt"));
        System.out.println(s);
        // 转换流
        String s2 = FileUtils.readFileToString(new File("bgk.txt"), "GBK");
        System.out.println(s2);
    }

    /*
    将String写到文件
    static void writeStringToFile(File, String, String, boolean)
    参数：文件，数据，编码，追加(很多重载的)
     */
    public static void fun_2() throws IOException {
        FileUtils.writeStringToFile(new File("CommonsGBK.txt"), "你好", "GBK",
                true);
        FileUtils.writeStringToFile(new File("CommonsUTF.txt"), "你好", "UTF-8",
                true);
    }

    /*
    复制文件
    static void copyFile(File src,File desc)
     */
    public static void fun_3() throws IOException {
        // 复制字节的，编码一样的复制
        FileUtils.copyFile(new File("bgk.txt"), new File("bgkCommons.txt"));
        FileUtils.copyFile(new File("utf.txt"), new File("utfCommons.txt"));
    }

    /*
    复制文件夹
    static void copy
     */
    public static void fun_4() throws IOException {
        FileUtils.copyDirectoryToDirectory(new File("day99_CommonsTest"),
                new File("day99_CommonsTestCopy"));
    }

}
