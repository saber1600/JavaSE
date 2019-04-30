package cn.wangbowen.demo1;

/**
 * 第二种创建线程的方式：实现Runnable接口，重写run方法
 */
public class RunThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("run..." + i);
        }
    }
}
