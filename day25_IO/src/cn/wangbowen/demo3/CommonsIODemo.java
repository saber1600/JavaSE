package cn.wangbowen.demo3;

import org.apache.commons.io.FilenameUtils;

/**
 * 第三方IO工具类
 */
public class CommonsIODemo {
    public static void main(String[] args) {
        fun_1();
        fun_2();
        fun_3();
    }

    /*
    FilenameUtils类的方法
    static String getExtension(String filename)
    获取文件名的扩展名
     */
    public static void fun_1() {
        String name = FilenameUtils.getExtension("aaa.java111");
        System.out.println(name);
    }

    /*
    static String getName(String filename)
    获取文件名
     */
    public static void fun_2() {
        System.out.println(FilenameUtils.getName("windows.txt"));
    }

    /*
    static boolean isExtension(String, String)
    判断是否以后缀名结尾的文件
     */
    public static void fun_3() {
        // 区分大小写
        System.out.println(FilenameUtils.isExtension("test.txt", "TXT"));
    }

}
