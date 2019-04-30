package cn.wangbowen.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
数据库操作的步骤6部
有SQL注入危险
 */
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.注册驱动（根据反射机制）
        Class.forName("com.mysql.jdbc.Driver");

        // 2.获取连接对象DriverManager.getConnection()返回Connection接口实现类
        // url = jdbc:mysql://机器IP:端口号（MySQL默认3306）/数据库名
        String url = "jdbc:mysql://localhost:3306/mybase";
        String user = "root";
        String password = "Bow1024";
        Connection conn = DriverManager.getConnection(url, user, password);

        // 3.获取执行SQL语句的对象Statement接口实现类
        // 不推荐！有SQL注入危险！
        Statement stat = conn.createStatement();

        // 4.执行SQL语句（executeUpdate方法只能操作insert,delete,update，有一个Int返回值，代表影响行数）
        String sql = "insert into sort(sname,sprice,sdesc) values('汽车',50000,'发达了')";
        int row = stat.executeUpdate(sql);

        // 5.操作返回结果
        System.out.println("影响行数：" + row);

        // 6.关闭资源
        stat.close();
        conn.close();
    }
}
