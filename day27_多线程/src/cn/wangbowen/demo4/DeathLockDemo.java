package cn.wangbowen.demo4;
/*
测试死锁机制，相互等待
 */
public class DeathLockDemo implements Runnable{
    @Override
    public void run() {
        int i = 0;
        DeathLockA A = DeathLockA.getInstance();
        DeathLockB B = DeathLockB.getInstance();
        while (true) {
            if (i % 2 == 0) {
                synchronized (A) {
                    System.out.println("if...LockA");
                    synchronized (B) {
                        System.out.println("if...LockB");
                    }
                }
            } else {
                synchronized (B) {
                    System.out.println("else...LockB");
                    synchronized (A) {
                        System.out.println("else...LockA");
                    }
                }
            }
            // 交替执行if-else
            i++;
        }
    }

    // 入口
    public static void main(String[] args) {
        System.out.println("死锁来拉！");
        DeathLockDemo dl = new DeathLockDemo();
        Thread t0 = new Thread(dl);
        Thread t1 = new Thread(dl);
        t0.start();
        t1.start();
    }
}
