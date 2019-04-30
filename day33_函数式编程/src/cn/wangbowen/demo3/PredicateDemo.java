package cn.wangbowen.demo3;

import java.util.function.Predicate;

/*
    预定义接口：Predicate<T> 用来判断真假
    方法test，接受一个参数，返回真假
 */
public class PredicateDemo {
    public static boolean isTure(String s, Predicate<String> predicate) {
        return predicate.test(s);
    }

    public static void main(String[] args) {
        String s = "asfbsdhjg";
        boolean b = PredicateDemo.isTure(s, str -> str.length() > 5);
        System.out.println(b);
    }
}
