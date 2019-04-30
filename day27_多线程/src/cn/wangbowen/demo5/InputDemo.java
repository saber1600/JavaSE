package cn.wangbowen.demo5;
/*
输入线程
 */
public class InputDemo implements Runnable {
    private Recourse r;

    public InputDemo(Recourse r) {
        this.r = r;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            // 注意这个锁，必须是和Output同一个锁.解决人妖问题
            synchronized (r) {
                // 如果输入完成,等待
                if (r.flag) {
                    try {
                        // 等待唤醒，必须是锁对象调用
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 交替修改
                if (i % 2 == 0) {
                    r.name = "张三";
                    r.sex = "男";
                } else {
                    r.name = "lisi";
                    r.sex = "nv";
                }
                // 修改flag，并唤醒输出线程
                r.flag = true;
                r.notify();
            }
            i++;
        }
    }
}
