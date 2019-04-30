package cn.wangbowen.demo1;

import java.util.ArrayList;

/*
    流的方法分为延迟方法和终结方法
        终结方法，就是流不能再继续使用
        常用的有forEach和count
 */
public class ForEach_Count {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // forEach
        list.stream().forEach(s -> System.out.println(s));

        // count 返回long类型
        long count = list.stream().count();
        System.out.println("个数：" + count);
    }
}
