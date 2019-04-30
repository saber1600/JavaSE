package cn.wangbowen.demo2;

/**
 * 方法三：匿名内部类
 */
public class ThreadDemo {
    public static void main(String[] args) {
        /*
        第一个，父类
         */
        new Thread() {
            public void run() {
                System.out.println("!!!");
            }
        }.start();

        /*
        第二个，接口
         */
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("@@@");
            }
        };
        Thread t = new Thread(r);
        t.start();

        /*
        结合起来
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("###");
            }
        }).start();
    }
}
