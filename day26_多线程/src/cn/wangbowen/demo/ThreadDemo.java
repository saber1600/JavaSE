package cn.wangbowen.demo;

public class ThreadDemo {
    public static void main(String[] args) {
        // 新建了一个线程
        SubThread st = new SubThread();
        // 这里新开了一个栈，和main一起抢夺CPU资源
        st.start();
        // run 和 main 有几率会交替执行！
        for (int i = 0; i < 50; i++) {
            System.out.println("main..." + i);
        }
    }
}
