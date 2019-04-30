package cn.wangbowen.demo3;

/**
 * 可以重写构造方法，来初始化命名
 */
public class ThreadTest extends Thread{
    public ThreadTest() {
        super("张三");
    }
}
