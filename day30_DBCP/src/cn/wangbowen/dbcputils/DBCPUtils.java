package cn.wangbowen.dbcputils;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
数据库连接池工具类
 */
public class DBCPUtils {
    // 1.创建一个DateSource接口的实现类，名字根据不同连接池厂商不同而不同阿里的是DruidDataSource
    private static BasicDataSource dataSource = null;

    // 2.静态代码块进行配置和初始化
    static {
        try {
            Properties pro = new Properties();
            pro.load(DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            // 得到一个数据源.这里需要做一个强转，因为返回的是一个接口，这个是要实现类
            dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3.获取数据源的方法(这里利用面向对象的思想，返回接口，便于可拓展性)
    public static DataSource getDataSource() {
        return dataSource;
    }

    // 小猴子www.monkey1024.com中是使用返回连接
    // 这里的连接是经过装饰后的，且连接是通过数据源对象的getConnection返回的
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            // 这个是给开发人员看的
             e.printStackTrace();
            // RuntimeException这个是运行时错误，会直接停掉程序
            throw new RuntimeException("服务器错误");
        }
    }

    /*
    释放资源
     */
    public static void close(Statement stmt, Connection conn) {
        /*if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();   //归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        // 简化
        close(null, stmt, conn);
    }
    // 重载
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();   //归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
