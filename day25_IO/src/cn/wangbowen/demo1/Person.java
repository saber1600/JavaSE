package cn.wangbowen.demo1;

import java.io.Serializable;

public class Person implements Serializable {

    // 解决序列化冲突问题：自定义序列号
    // 原因：当你修改了成员的某个属性的时候，重新编译class文件就会更新一个新的序列号
    private static final long serialVersionUID = 123456789L;

    private String name;
    private transient int age;

    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
