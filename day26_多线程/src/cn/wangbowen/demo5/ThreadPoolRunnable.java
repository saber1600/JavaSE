package cn.wangbowen.demo5;

/**
 * 实现线程池的Runnable接口
 */
public class ThreadPoolRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程");
    }
}
