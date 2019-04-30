package cn.wangbowen.demo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池,Executors工厂类
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建一个工厂类,调用其静态方法创建，参数是线程的个数。返回一个ExecutorService的接口实现类，即返回一个线程池对象
        ExecutorService es = Executors.newFixedThreadPool(2);
        // 调用submit(Runnable r)来执行线程
        es.submit(new ThreadPoolRunnable());
        es.submit(new ThreadPoolRunnable());
        es.submit(new ThreadPoolRunnable());
        // 一般程序不会结束，除非调用es.shutdown();。但是一般不会这么做

    }
}
