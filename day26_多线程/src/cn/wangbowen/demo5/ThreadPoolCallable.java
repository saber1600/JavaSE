package cn.wangbowen.demo5;

import java.util.concurrent.Callable;

/**
 *实现线程池的Callable接口
 * 具有返回值和抛异常的能力
 */
public class ThreadPoolCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return "abc";
    }
}
