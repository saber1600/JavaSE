package cn.wangbowen.demo2;
/*
购票类,使用同步方法（静态方法），锁是 本类.class
 */
public class ThreadTicket implements Runnable{
    private static int tickets = 100;
    @Override
    public void run() {
        pay();
    }

    public static synchronized void pay() {
        while (true) {
            if (tickets > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 售票demo2：" + tickets--);
            }
        }
    }
}