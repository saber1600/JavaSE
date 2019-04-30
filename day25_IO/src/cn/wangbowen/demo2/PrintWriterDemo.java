package cn.wangbowen.demo2;

import java.io.*;

/**
 *  打印流 (方便打印各种数据形式)
 *  PrintStream
 *  PrintWriter
 *  特点：1.不会抛出IO异常，但是可能抛出其他异常
 *        2.此流不负责数据源，只负责数据目的
 *        3.为其他输出流，添加功能
 *
 *  两个打印流方法完全一致
 *  构造方法，就是打印流的输出目的端
 *      PrintStream
 *          构造方法：接受File,OutputStream,字符串文件名
 *      PrintWriter(常用，因为多了一个Writer)
 *          构造方法：接受File,OutputStream,字符串文件名，字符输出流Writer
 *
 *
 */
public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
        function();
        function_1();
        function_2();
        fun();
    }

    /*
    开启自动刷新功能
    条件:
        1.输出目的，必须是流对象。
        2.必须调用println,printf,format三个方法中的一个，才可以自动刷新（即不用flush）
     */
    public static void fun() throws IOException {
        // 第二个参数，为true。启动
        PrintWriter pw = new PrintWriter(new FileWriter("print_5.txt"), true);
        pw.println("打印流");
        pw.println("df 的");
        pw.println("的身份");
        // 必须要关闭，不管刷不刷新
        pw.close();
    }

    /*
    打印流，向File对象的数据目的写入数据
     方法print,println
     */
    public static void function() throws FileNotFoundException {
        File file = new File("print_1.txt");
        // 第二个可选参数，是指定字符集
        PrintWriter pw = new PrintWriter(file);
        // print不同于write，原封不动的打印
        pw.print(100);
        pw.write(100);
        // 因为是write，所以要flush
        pw.close();
    }
    /*
    参数：字符串文件名
     */
    public static void function_1() throws FileNotFoundException {
        // 第二个可选参数，是指定字符集
        PrintWriter ps = new PrintWriter("print_2.txt");
        ps.println(3.5);
        ps.close();
    }
    /*
    参数：字节输出流，字符输出流都可以
     */
    public static void function_2() throws IOException {
        //FileOutputStream fos = new FileOutputStream("print_3.txt");
        FileWriter fw = new FileWriter("print_4.txt");
        //PrintWriter pw = new PrintWriter(fos);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("打印流");
        pw.close();
    }

}
