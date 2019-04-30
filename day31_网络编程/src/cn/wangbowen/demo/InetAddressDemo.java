package cn.wangbowen.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
这是一个IP地址类
 */
public class InetAddressDemo {

    public static void main(String[] args) throws UnknownHostException {
        // 没有构造函数，只能通过静态方法获取
        // 获取本地IP：InetAddress.getLocalHost();
        InetAddress ia = InetAddress.getLocalHost();
        System.out.println(ia);
        // 获取别人的IP地址：InetAddress.getByName();参数是主机名或者IP地址
        InetAddress ia2 = InetAddress.getByName("www.wangbowen.cn");
        // 获取主机名
        System.out.println(ia2.getHostName());
        // 获取IP地址
        System.out.println(ia2.getHostAddress());
    }
}
