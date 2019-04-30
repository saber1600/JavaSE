package cn.wangbowen.demo;

/**
 * 创建线程的第一种方法：继承Thread类,重写run方法
 */
public class SubThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("run..." + i);
        }
    }
}
