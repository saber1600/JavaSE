package cn.wangbowen.demo3;

import java.util.function.Predicate;

/*
    and方法
    or方法
 */
public class PredicateDemo1 {
    public static boolean isTure(String str, Predicate<String> pre1, Predicate<String> pre2) {
        // 等同于 pre1.test(str) && pre2.test(str);
        return pre1.and(pre2).test(str);
    }

    public static boolean isTure1(String str, Predicate<String> pre1, Predicate<String> pre2) {
        // 等同于 pre1.test(str) || pre2.test(str);
        return pre1.or(pre2).test(str);
    }

    public static void main(String[] args) {
        String str = "gsduifgsdhu";
        // 判断字符串长度大于5，且包含a
        boolean b = PredicateDemo1.isTure(str, s -> s.length() > 5, s -> s.contains("a"));
        System.out.println(b);

        // 判断字符串长度大于5，或包含a
        boolean b1 = PredicateDemo1.isTure1(str, s -> s.length() > 5, s -> s.contains("a"));
        System.out.println(b1);

    }
}
