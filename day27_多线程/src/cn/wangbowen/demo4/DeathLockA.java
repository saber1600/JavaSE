package cn.wangbowen.demo4;
/*
使用单例模式，来构造对象唯一（饿汉式）
 */
public class DeathLockA {
    // 1.私有构造函数
    private DeathLockA() {}
    // 2.创建本类对象(volatile关键字，保证了可见性，但是不保证原子性)
    private static volatile DeathLockA d = new DeathLockA();
    // 3.对外提供方法
    public static DeathLockA getInstance() {
        return d;
    }
}
