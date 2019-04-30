package cn.wangbowen.demo5;
/*
主线程，交替修改值，并输出。
唤醒，等待线程，Demo
 */
public class WaitNotifyDemo {
    public static void main(String[] args) {
        Recourse r = new Recourse();
        InputDemo in = new InputDemo(r);
        OutputDemo out = new OutputDemo(r);
        Thread t0 = new Thread(in);
        Thread t1 = new Thread(out);
        t0.start();
        t1.start();
    }
}
