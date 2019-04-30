package cn.wangbowen.demo;

import cn.wangbowen.bean.Sort;
import cn.wangbowen.dbutils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/*
数据库工具包（对增删改查的简化，且对数据返回的结果集进行更友好的处理）
 */
public class DBUtilDemo {
    public static void main(String[] args) throws SQLException {
        //update();
        //queryArrayHandler();
        //queryArrayListHandler();
        //queryBeanHandler();
        //queryBeanListHandler();
        //queryMapHandler();
        //queryMapListHandler();
        //queryColumnListHandler();
        queryScalarHandler();
    }

    /*
    更新操作
     */
    public static void update() {
        // 0.获取数据库连接对象(这里就用之前的那个工具类)
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("连接错误");
        }
        // 1.使用QueryRunner类定义一个类
        QueryRunner qr = new QueryRunner();
        // 2.进行SQL操作
        // 更新操作
        // int update(Connection conn, String sql, Object... params)
        // 最后一个参数是可变参数，这里可以传一个数组进去，不过数据要和SQL语句的？占位符一一对应

        String sql = "insert into sort(sname,sprice,sdesc) values(?,?,?)";
        try {
            // 这里也可以参数变为一个数组，但是对应位置要一一对应
            int row = qr.update(conn, sql, "电脑", 20000, "PC");
            System.out.println("影响：" + row + "行");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    查询方法query。
    <T>T query(Connection conn, String sql, ResultSetHandler r, Object... params)
        其中 ResultSetHandler是结果集的处理方式，传递接口实现类，有8种
        返回值是泛型，传递接口实现类的不同而不同
     */

    // ArrayHandler返回结果集第一行的数据，以数组的形式
    public static void queryArrayHandler() throws SQLException {
        // 0.获取数据库连接对象(这里就用之前的那个工具类)
        Connection conn = JDBCUtils.getConnection();
        // 1.使用QueryRunner类定义一个类
        QueryRunner qr = new QueryRunner();
        // 2.查询操作
        String sql = "select * from sort";
        Object[] objs = qr.query(conn, sql, new ArrayHandler());
        // 结果只显示第一行的
        System.out.println("一共有多少数据：" + objs.length);
        for (Object obj : objs) {
            System.out.print(obj + "\t");
        }
    }

    // ArrayListHandler返回每一行结果集，每一条用Object数组存，最后用List存所有Object数组
    public static void queryArrayListHandler() throws SQLException {
        // 0.获取数据库连接对象(这里就用之前的那个工具类)
        Connection conn = JDBCUtils.getConnection();
        // 1.使用QueryRunner类定义一个类
        QueryRunner qr = new QueryRunner();
        // 2.查询操作
        String sql = "select * from sort";
        List<Object[]> list = qr.query(conn, sql, new ArrayListHandler());
        // 结果只显示第一行的
        System.out.println("一共有多少数据：" + list.size());
        for (Object[] objs : list) {
            for (Object obj : objs) {
                System.out.print(obj + "\t");
            }
            System.out.println();
        }
    }

    // BeanHandler返回一个Javabean对象.这里注意<>中写javabean对象，（）中是类型，用反射机制
    public static void queryBeanHandler() throws SQLException {
        // 0.获取数据库连接对象(这里就用之前的那个工具类)
        Connection conn = JDBCUtils.getConnection();
        // 1.使用QueryRunner类定义一个类
        QueryRunner qr = new QueryRunner();
        // 2.查询操作
        String sql = "select * from sort";
        Sort s = qr.query(conn, sql, new BeanHandler<Sort>(Sort.class));
        System.out.println(s);
    }

    // BeanListHandler返回一个List<Javabean>对象
    public static void queryBeanListHandler() throws SQLException {
        // 0.获取数据库连接对象(这里就用之前的那个工具类)
        Connection conn = JDBCUtils.getConnection();
        // 1.使用QueryRunner类定义一个类
        QueryRunner qr = new QueryRunner();
        // 2.查询操作
        String sql = "select * from sort";
        List<Sort> sortList = qr.query(conn, sql, new BeanListHandler<Sort>(Sort.class));
        for (Sort s : sortList) {
            System.out.println(s);
        }
    }

    // MapHandler返回一个Map<String, Object>对象
    public static void queryMapHandler() throws SQLException {
        // 0.获取数据库连接对象(这里就用之前的那个工具类)
        Connection conn = JDBCUtils.getConnection();
        // 1.使用QueryRunner类定义一个类
        QueryRunner qr = new QueryRunner();
        // 2.查询操作
        String sql = "select * from sort";
        Map<String, Object> map = qr.query(conn, sql, new MapHandler());
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }

    // MapListHandler返回一个List<Map<String, Object>>对象
    public static void queryMapListHandler() throws SQLException {
        // 0.获取数据库连接对象(这里就用之前的那个工具类)
        Connection conn = JDBCUtils.getConnection();
        // 1.使用QueryRunner类定义一个类
        QueryRunner qr = new QueryRunner();
        // 2.查询操作
        String sql = "select * from sort";
        List<Map<String, Object>> mapList = qr.query(conn, sql, new MapListHandler());
        for (Map<String, Object> map : mapList) {
            for (String key : map.keySet()) {
                System.out.println(key + ":" + map.get(key));
            }
        }
    }

    // ColumnListHandler用来处理结果集中的某一列（字段）返回一个List<Object>
    // <>中写Object因为每一列返回的结果集可能不一样，（）中写字段名
    public static void queryColumnListHandler() throws SQLException {
        // 0.获取数据库连接对象(这里就用之前的那个工具类)
        Connection conn = JDBCUtils.getConnection();
        // 1.使用QueryRunner类定义一个类
        QueryRunner qr = new QueryRunner();
        // 2.查询操作
        String sql = "select * from sort";
        List<Object> list = qr.query(conn, sql, new ColumnListHandler<Object>("sname"));
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    // ScalarHandler用来处理结果集中只有一个结果的情况，如聚合函数只会返回一个结果
    public static void queryScalarHandler() throws SQLException {
        // 0.获取数据库连接对象(这里就用之前的那个工具类)
        Connection conn = JDBCUtils.getConnection();
        // 1.使用QueryRunner类定义一个类
        QueryRunner qr = new QueryRunner();
        // 2.查询操作
        String sql = "select count(*) from sort";
        // 这里泛型中使用包装类
        long count = qr.query(conn, sql, new ScalarHandler<Long>());
        System.out.println("一共有：" + count + " 条数据");
    }

}
