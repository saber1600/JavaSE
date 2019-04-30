package cn.wangbowen.demo1;

import java.util.function.Supplier;

/*
    使用JDK8内置预定义接口：XxxSupplier<T>
        也称为生产型接口，指定泛型就会返回对应的类型。
        有一个方法get()，无参，利用逻辑返回一个值。
 */
public class SupplierDemo {
    // 定义一个方法判断数组中最大值，参数是函数式接口
    public static int getMax(Supplier<Integer> sup) {
        // 调用get方法，返回一个值。具体实现，由调用时的lambda表达式决定
        return sup.get();
    }


    public static void main(String[] args) {
        int[] ary = {2, 58, 623, 5, 8, 589, 5, 4, 5};
        // 形参是函数是接口，实参是lambda表达式
        int maxValue = SupplierDemo.getMax(()->{
            // lambda表达式可以其访问外层作用域定义的局部变量。但是lambda表达式不能修改外层局部变量的值。
            // 相当于lambda表达式将外层局部变量当做 final常量来使用.初始化的外层局部变量不能被lambda表达式访问，
            // 也不能在lambda块内对其初始化
            int max = Integer.MIN_VALUE;
            for (int i : ary) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });

        System.out.println("最大值：" + maxValue);
    }
}
