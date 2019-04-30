package cn.wangbowen.jdbcutils;

import java.sql.Connection;
import java.sql.SQLException;

/*
测试类
 */
public class JDBCUtilsTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }
}
