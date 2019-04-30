package cn.wangbowen.demo;
/*
    函数式接口：有且仅有一个抽象方法。他是一个接口！
 */

// JDK8新增注解，用来检测是一个函数式接口
@FunctionalInterface
public interface FunInterface {
    // 有且只有一个抽象方法 public abstract可以省略
    public abstract void showValue();
}
