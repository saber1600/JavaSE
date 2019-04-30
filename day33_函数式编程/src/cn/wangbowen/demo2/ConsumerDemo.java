package cn.wangbowen.demo2;

import java.util.function.Consumer;

/*
    预定义函数式接口：Consumer<T>
        消费型接口，对数据进行消费操作。没有返回值
        accept方法，接受一个参数，该参数是泛型，即对该参数进行操作，具体操作由lambda方法体实现。
 */
public class ConsumerDemo {
    public static void show(String s, Consumer<String> con) {
        // 对其消费（打印操作）
        con.accept(s);
    }

    public static void main(String[] args) {
        ConsumerDemo.show("Heelo World!", s -> System.out.println(s));
    }

}
