package cn.wangbowen.demo1;

import java.io.*;

/**
 * 对象的序列化和反序列化
 * 条件：对象需要实现Serialisiable（标记性接口，此接口没有任何方法）
 * 对象必须实现Serializable接口，且静态成员或者transient修饰的成员不能序列化
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        readObject();
        writeObject();
    }
    /*
    序列化 ObjectOutputStream
    构造参数：OutputStream out
    方法：writeObject(Object obj)
     */
    public static void readObject() throws IOException {
        // 创建输出流
        FileOutputStream fos = new FileOutputStream("person.txt");
        // 序列化流
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // 创建对象(该对象必须实现Serializable接口，且静态成员或者transient修饰的成员不能序列化)
        Person p = new Person("zhangsan", 18);
        // 序列化
        oos.writeObject(p);
        // 关闭资源
        oos.close();
    }

    /*
    反序列化 ObjectInputStream
    构造参数：InputStream in
    方法：Object readObject()
     */
    public static void writeObject() throws IOException, ClassNotFoundException {
        // 创建输入流
        FileInputStream fis = new FileInputStream("person.txt");
        // 创建反序列化流
        ObjectInputStream ois = new ObjectInputStream(fis);
        // 反序列化(这里必须相对应的类的class文件要存在，否则抛出找不到类异常)
        Object obj = ois.readObject();
        System.out.println(obj);
        System.out.println("因为age是transient修饰成员不能序列化，而这里的0是，默认值");
        System.out.println("另外，static静态成员变量也不能序列化");
        // 关闭资源
        ois.close();

    }
}
