package cn.wangbowen.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/*
    Construct构造器
    主要操作：
        1. 获取构造器Construct
        2. 创建实例newInstance
 */
public class ConstructDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // 获取Class的三种方式，第二种（通过对象实例获取Class）
        Person per = new Person();
        Class perClass = per.getClass();

        // 获取构造器
        // 获取指定的public构造器（参数是类型的Class对象）
        Constructor constructor = perClass.getConstructor(String.class, String.class);
        System.out.println("获取指定构造器：" + constructor);
        // 获取所有public构造器
        Constructor[] constructors = perClass.getConstructors();
        System.out.println("所有Public构造器：");
        Arrays.stream(constructors).forEach(c -> System.out.println(c));

        // 获取所有权限构造器(数组)  。和属性一样，就不再展开。
        // Constructor declaredConstructor = perClass.getDeclaredConstructor();
        // Constructor[] declaredConstructors = perClass.getDeclaredConstructors();


        System.out.println("******************************************");
        // 利用构造器创建实例（返回Object类型）【注意：被调用的对象是构造器Construct。如果是私有的直接暴力反射】
        Object o = constructor.newInstance("1", "2");
        System.out.println(o);
        // 如果是空参构造器，可以直接用Class对象生成
        Object o1 = perClass.newInstance();
        System.out.println(o1);

    }
}
