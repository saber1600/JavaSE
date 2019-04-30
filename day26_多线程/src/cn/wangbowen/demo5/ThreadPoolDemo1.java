package cn.wangbowen.demo5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用Callable接口，可以有返回值和抛出异常。
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        // submit返回一个Future接口的实现类
        Future<String> f = es.submit(new ThreadPoolCallable());
        // Future有一个get方法可以获得返回的值
        System.out.println(f.get());
    }
}
