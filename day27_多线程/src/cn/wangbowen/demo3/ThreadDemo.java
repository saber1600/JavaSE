package cn.wangbowen.demo3;

/*
售票系统：开3个线程，运行
 */
public class ThreadDemo {
    public static void main(String[] args) {
        ThreadTicket tt = new ThreadTicket();
        Thread t0 = new Thread(tt);
        Thread t1 = new Thread(tt);
        Thread t2 = new Thread(tt);

        t0.start();
        t1.start();
        t2.start();
    }
}
