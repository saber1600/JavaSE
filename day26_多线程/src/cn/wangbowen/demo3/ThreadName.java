package cn.wangbowen.demo3;

/**
 * 线程的命名
 */
public class ThreadName {
    public static void main(String[] args) {
        // 获取当前线程(main线程只能用这个)的线程名，使用静态方法
        System.out.println(Thread.currentThread().getName());

        // Thread的构造器接受一个String的参数，作为名字
        ThreadTest tt = new ThreadTest();
        // 获取名字方法
        System.out.println(tt.getName());
        // 设置名字方法
        tt.setName("李四");
        System.out.println(tt.getName());

    }
}
