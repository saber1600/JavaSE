package cn.wangbowen.demo1;
/*
购票类,使用同步方法，锁是本类对象的this
 */
public class ThreadTicket implements Runnable{
    private int tickets = 100;
    @Override
    public void run() {
        pay();
    }

    public synchronized void pay() {
        while (true) {
            if (tickets > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 售票demo1：" + tickets--);
            }
        }
    }
}
