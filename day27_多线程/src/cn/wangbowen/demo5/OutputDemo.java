package cn.wangbowen.demo5;
/*
输出资源
 */
public class OutputDemo implements Runnable{
    Recourse r;

    public OutputDemo(Recourse r) {
        this.r = r;
    }

    @Override
    public void run() {
        // 注意这个锁，必须是和Input同一个锁.解决人妖问题
        while (true) {
            synchronized (r) {
                if (!r.flag) {
                    try {
                        // 等待、唤醒，必须所对象调用
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(r.name + "..." + r.sex);
                // 更新标记
                r.flag = false;
                r.notify();
            }
        }
    }
}
