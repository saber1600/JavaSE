package cn.wangbowen.demo2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Stream;

/*
    流的常用方法
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1231234");
        list.add("4575888888");
        list.add("7456");
        list.add("755");
        list.add("78686");
        list.add("731553");
        list.add("7841");

        // 因为list的泛型是String，所以函数式接口都是String
        // filter 过滤,使用Predicate函数式接口（断言）
        Stream<Integer> stream1 = list.stream().filter((String s) -> {return s.startsWith("7");})
                                        // map 映射，使用Function函数式接口（转换）
                                        .map(s -> Integer.parseInt(s))
                                        // 这里注意转换后是Integer类型了
                                        .filter(i -> i > 1000)
                                        // 跳过n个，如果没有n个返回空流
                                        .skip(2);


        Stream<String> stream2 = list.stream().limit(2);  // limit 取前n个

        // Stream静态方法concat连接两个流
        Stream<? extends Serializable> concat = Stream.concat(stream1, stream2);

        concat.forEach(s -> System.out.println(s));

    }
}
