package cn.wangbowen.demo;

import java.lang.reflect.Field;
import java.util.Arrays;

/*
    Field属性及相关操作
    主要有：
        获取Filed对象（数组）
        get操作
        set操作
        setAccessible暴力反射
 */
public class FieldDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        // 获取Class的三种方式，第一种：通过 类名.class
        Class personClass = Person.class;

        // 通过该类Class获取该类的属性
        // public权限
        // getFields();返回Field数组。获取所有public的Field对象（注意是public权限的）
        Field[] fields = personClass.getFields();
        System.out.println("获取所有public属性：");
        Arrays.stream(fields).forEach(field -> System.out.println(field));
        // 获取指定Field名的对象
        Field publicField = personClass.getField("publicField");
        System.out.println("获取指定public属性：" + publicField);

        System.out.println("***************************************************************************************");
        // 所有权限
        // getDeclaredFields();返回Field数组，获取所有的Field对象
        Field[] declaredFields = personClass.getDeclaredFields();
        System.out.println("获取所有属性：");
        Arrays.stream(declaredFields).forEach(d -> System.out.println(d));
        // 获取指定属性名
        Field privateField = personClass.getDeclaredField("privateField");
        System.out.println("获取指定private属性" + privateField);

        System.out.println("***************************************************************************************");
        Person per = new Person("1", "2", "3", "4");
        // get操作。获取某对象的某属性值
        Object o = publicField.get(per);
        System.out.println("get操作获取的某对象的值：" + o);
        // set操作。对某对象的某属性值进行修改。（对私有权限操作的时候，要注意关闭安全检查）
        // 关闭安全检查（暴力反射）。不加下面行代码，会抛异常
        privateField.setAccessible(true);
        privateField.set(per, "private");
        System.out.println("暴力反射修改值:" + per);

    }
}
