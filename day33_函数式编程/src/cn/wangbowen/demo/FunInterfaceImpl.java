package cn.wangbowen.demo;
/*
    用lambda和匿名内部类实现函数式接口（注意，有函数式接口的地方就能用lambda表达式）
    其实，lambda就可以理解为，实现了抽象方法
 */
public class FunInterfaceImpl {
    // 定义一个方法，参数是接口(记住：这只是参数，具体怎么用，是该方法的具体实现)
    public static void function(FunInterface fun) {
        // 调用接口中的方法(这里不用具体实现)
        fun.showValue();
    }

    // 主函数
    public static void main(String[] args) {
        // new一个实现类
        FunInterfaceImpl f = new FunInterfaceImpl();
        // 使用匿名内部类实现抽象方法(要去实现这个方法)
        f.function(new FunInterface() {
            @Override
            public void showValue() {
                System.out.println("使用匿名内部类");
            }
        });

        // 使用lambda表达式
        // 只要是函数式接口为参数，实参就可以直接是lambda表达式
        f.function(()-> System.out.println("使用lambda表达式"));
    }
}
