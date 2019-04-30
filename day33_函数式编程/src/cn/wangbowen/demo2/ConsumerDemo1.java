package cn.wangbowen.demo2;

import java.util.function.Consumer;

/*
    Consumer的andThen方法：将两个Consumer接口绑定到一起
 */
public class ConsumerDemo1 {
    // 对字符串进行2个输出，用2个不同Consumer
    public static void show(String[] strs, Consumer<String> con1, Consumer<String> con2) {
        for (String str : strs) {
            // 等同于 con1(str); con2(str);
            // 哪个在前面，先消费哪个
            con2.andThen(con1).accept(str);
        }
    }

    public static void main(String[] args) {
        String[] strs = {"管理员1，男", "管理员2，女"};
        ConsumerDemo1.show(strs, (s) -> {
            System.out.println(s.split("，")[0]);
        }, (s -> System.out.println(s.split("，")[1])));
    }
}
