package cn.wangbowen.demo4;

import java.util.Arrays;
import java.util.function.Function;

/*
    预定义接口：Function<T, R> 转换功能，将T类型，转为V类型
    方法apply，接受一个T类型

    andThen方法和之前的类似
 */
public class FunctionDemo {
    public static Integer change(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    public static void main(String[] args) {
        Integer i = FunctionDemo.change("123", s -> Integer.parseInt(s));
        System.out.println(i);
        int[] s = {1};
    }
}
