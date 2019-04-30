package cn.wangbowen.demo;
/*
    示例类
 */
public class Person {
    // 4种权限修饰符
    public String publicField;
    private String privateField;
    String defaultField;
    protected String protectedField;

    // 构造函数
    public Person() {}

    private Person(int tmp) {
        System.out.println("私有构造函数");
    }

    public Person(String publicField, String privateField) {
        this.publicField = publicField;
        this.privateField = privateField;
    }


    public Person(String publicField, String privateField, String defaultField, String protectedField) {
        this.publicField = publicField;
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.protectedField = protectedField;
    }

    // 方法

    public void sleep() {
        System.out.println("睡觉");
    }
    public void eat(String food) {
        System.out.println("吃" + food);
    }


    public String getPublicField() {
        return publicField;
    }

    public void setPublicField(String publicField) {
        this.publicField = publicField;
    }

    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String privateField) {
        this.privateField = privateField;
    }

    public String getDefaultField() {
        return defaultField;
    }

    public void setDefaultField(String defaultField) {
        this.defaultField = defaultField;
    }

    public String getProtectedField() {
        return protectedField;
    }

    public void setProtectedField(String protectedField) {
        this.protectedField = protectedField;
    }

    @Override
    public String toString() {
        return "Person{" +
                "publicField='" + publicField + '\'' +
                ", privateField='" + privateField + '\'' +
                ", defaultField='" + defaultField + '\'' +
                ", protectedField='" + protectedField + '\'' +
                '}';
    }
}
