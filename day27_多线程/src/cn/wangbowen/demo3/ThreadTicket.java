package cn.wangbowen.demo3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
购票类
JDK1.5之后，增加了一个Lock接口，来代替synchronized
java.util.concurrent.locks
 */
public class ThreadTicket implements Runnable{
    private int tickets = 100;
    // 1.先定义一个Lock接口的实现类ReentrantLock()，作用相当于锁
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        pay();
    }

    public void pay() {
        while (true) {
            // 2.加锁
            lock.lock();
            if (tickets > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + " 售票demo3：" + tickets--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 3.释放锁
                    lock.unlock();
                }
            }
        }
    }
}