package cn.wangbowen.demo;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    Stream流，是对集合和数组的操作（尤其是在多次遍历数组或集合时候）
    流的获取方法有两种
        1.通过集合的stream方法
        2.通过Stream接口的静态方法of
    流能配合lambda表达式，更有处理能力
    流只能被消费一次，再次消费会抛异常
 */
public class StreamDemo {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        // 第一种获取
        Stream<String> stream1 = list.stream();
        stream1.forEach(str -> System.out.print(str + ","));

        System.out.println();
        // 第二种
        Stream<ArrayList<String>> list2 = Stream.of(list);
        list2.forEach(str-> System.out.println(str));

    }

}
