package cn.wangbowen.demo1;

public class ThreadDemo {
    public static void main(String[] args) {
        // 创建一个接口
        Runnable rt = new RunThread();
        // 创建一个线程，传参
        Thread t = new Thread(rt);
        // 开启线程
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main..." + i);
        }
    }
}
