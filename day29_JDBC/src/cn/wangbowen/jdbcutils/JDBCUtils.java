package cn.wangbowen.jdbcutils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/*
数据量工具类
 */
public class JDBCUtils {
    private static Connection conn;

    private static String driverClass;
    private static String url;
    private static String user;
    private static String password;

    private JDBCUtils(){}

    static {
        try {
            //readConfig();
            readConfig1();
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 使用Properties读取配置文件
    private static void readConfig() throws IOException {
        InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties pro = new Properties();
        pro.load(in);
        driverClass = pro.getProperty("driverClass");
        url = pro.getProperty("url");
        user = pro.getProperty("user");
        password = pro.getProperty("password");
    }

    // 使用ResourceBundle读取配置文件
    private static void readConfig1() throws IOException {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        driverClass = rb.getString("driverClass");
        url = rb.getString("url");
        user = rb.getString("user");
        password = rb.getString("password");
    }

    public static Connection getConnection() throws SQLException {
        return conn;
    }

}
