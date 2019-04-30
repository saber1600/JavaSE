package cn.wangbowen.demo4;
/*
使用单例模式，来构造对象唯一（懒汉式）
 */
public class DeathLockB {
    // 1.构造方法私有
    private DeathLockB(){}
    // 2.创建本类对象的引用
    private static volatile DeathLockB d;
    // 3.对外提供方法
    public static DeathLockB getInstance() {
        if (d == null) {
            // 这里可能有其他线程进入，双重保证？但是，为什么不直接在外面加同步呢
            synchronized (DeathLockB.class) {
                if (d == null) {
                    d = new DeathLockB();
                }
            }
        }
        return d;
    }
}
