package cn.wangbowen.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
    Method方法
    操作：
        1. 获取方法
        2. 调用方法
 */
public class MethodDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // 获取Class的三种方式，第三种（通过Class静态方法）【注意：要把包名写全，不然会找不到】
        Class perClass = Class.forName("cn.wangbowen.demo.Person");
        // 获取指定public方法（方法签名为：方法名，参数列表）
        Method method = perClass.getMethod("eat", String.class);
        System.out.println("获取指定方法：" + method);
        System.out.println("获取方法名getName：" + method.getName());
        // 获取所有public方法【会把父类的方法也打印出来】
        Method[] methods = perClass.getMethods();
        System.out.println("所有public方法：");
        Arrays.stream(methods).forEach(m -> System.out.println(m));

        // 获取所有权限的方法
        // Constructor declaredConstructor = perClass.getDeclaredConstructor();
        // Constructor[] declaredConstructors = perClass.getDeclaredConstructors();


        System.out.println("*********************************");
        Person p = new Person();
        // invoke调用方法,对象是方法（方法签名：被调用的对象实例, 参数列表）【如果是私有方法，用暴力反射】
        method.invoke(p, "饭");

    }
}
