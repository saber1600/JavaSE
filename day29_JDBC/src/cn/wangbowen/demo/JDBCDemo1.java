package cn.wangbowen.demo;

import java.sql.*;

/*
推荐的方式
 */
public class JDBCDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1
        Class.forName("com.mysql.jdbc.Driver");
        // 2
        String url = "jdbc:mysql://localhost:3306/mybase";
        String user = "root";
        String password = "Bow1024";
        Connection conn = DriverManager.getConnection(url, user, password);
        // 3.获取操作SQL语句对象
        // 这里是选择Statement的子接口PreparedStatement
        // conn.prepareStatement()返回一个子接口的实现类，参数是要执行的SQL语句，其中参数用?占位符
        String sql = "select * from sort where sprice > ?";
        PreparedStatement pers = conn.prepareStatement(sql);
        // 设置参数,第一个是占位符下标，从1开始。第二个是实际传入的参数
        pers.setDouble(1, 2000);

        // 4.执行SQL获取返回值
        // executeQuery方法只能用于select语句，更新是executeUpdate.
        // 返回一个结果集ResultSet接口实现类
        ResultSet rs = pers.executeQuery();

        // 5.处理结果
        // ResultSet有一个方法next()。返回boolean用于判断是否还有数据
        // 推荐使用rs.getXXX("字段名")  这里的XXX根据实际情况取值，和数据库对应
        while (rs.next()) {
            System.out.println("sid=" + rs.getInt("sid") + ", sname=" + rs.getString("sname")
                + ", sprice=" + rs.getDouble("sprice") + ", sdesc=" + rs.getString("sdesc"));
        }

        // 6.关闭资源
        rs.close();
        pers.close();
        conn.close();
    }
}
