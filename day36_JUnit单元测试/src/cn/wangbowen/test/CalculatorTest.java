package cn.wangbowen.test;

import cn.wangbowen.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/*
    单元测试
    1. 放在test包下
    2. 没有参数，和无返回值
    3. 类名：被测类名Test
    4. 方法名：testXxxx
    5. 断言
 */
public class CalculatorTest {

    // 注解Before  初始化方法，一般再单元测试之前被执行，用于创建资源。
    @Before
    public void init() {
        System.out.println("初始化...");
    }

    //注解After  释放资源，再测试单元之后被执行
    @After
    public void close() {
        System.out.println("关闭...");
    }

    // 注解Test  测试单元
    @Test
    public void testAdd() {

        // 创建类实例
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);
        System.out.println("测试体1...");
        // 一般不用输出sout，用断言。第一个参数是期待的值，第二个是结果
        // 运行后，如果正确，显示绿色，不合符预期或者抛异常，显示红色
        Assert.assertEquals(0, result);

        // 异常之后的代码不执行
        System.out.println("测试体2...");
    }
}
