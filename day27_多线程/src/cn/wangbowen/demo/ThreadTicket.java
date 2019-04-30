package cn.wangbowen.demo;
/*
购票类,使用同步代码块(会有性能问题，安全了，运行时间就多了)
 */
public class ThreadTicket implements Runnable{
    private int tickets = 100;
    // 1. 定义一个对象
    private Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            // 2. 使用同步代码块，并传入参数obj，这里obj相当于一个锁(这里改成this一样)
            synchronized (obj) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 售票demo：" + tickets--);
                }
            }
        }
    }
}
