package cn.wangbowen.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties 集合对象
 *      继承HashTable，实现了Map接口
 *      配置文件，以键值对(都是String)形式存储
 *      文件xxx.properties中的注释是在行首加’#‘
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        // 创建对象
        Properties pro = new Properties();
        function_1(pro);
        function_2(pro);
        function_3(pro);
        System.out.println("更改后：");
        function_1(pro);
    }

    /*
    1.加载properties文件，使用Load方法
     */
    public static void function_1(Properties pro) throws IOException {
        // 创建流
        FileReader fr = new FileReader("pro.properties");
        // 将文件加载到集合
        pro.load(fr);
        // 加载完就可以关闭流了
        fr.close();
        // 输出内容
        System.out.println(pro);
    }

    /*
    2.Properties的操作，获取和设置
     */
    public static void function_2(Properties pro) throws IOException {
        // 获取对应键的值
        String value = pro.getProperty("email");
        System.out.println(value);
        // 设置键值对
        pro.setProperty("sex", "nan");
        pro.setProperty("age", "18");
    }

    /*
    3.将Properties写到文件中，使用store
     */
    public static void function_3(Properties pro) throws IOException {
        // 创建流
        FileWriter fw = new FileWriter("pro.properties");
        // 写到文件中，第二个参数是原因，即为什么写道文件，可以不写为空字符串
        pro.store(fw, "Because:");
        // 关闭流
        fw.close();

    }
}
