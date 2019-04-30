package cn.wangbowen.dbcputils;

import cn.wangbowen.bean.Sort;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/*
测试类
在使用中就没有涉及到连接池的代码了，只用到工具类（都集成进去了）
 */
public class DBCPUtilsTest {
    // 定义一个第三方工具包来方便处理结果
    // 这里选择带参数（DataSource ds）的构造方法，那么之后query和update方法就不用写第一个Connection对象了
    private static QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());

    public static void main(String[] args) {
        insert();
        select();
    }

    // 添加数据
    public static void insert() {
        String sql = "insert into memberOfRK(tel) values(?)";
        Object[] params = {"狗粮", -666, "情人节到了"};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException("添加失败");
        }
    }
    // 查询数据
    public static void select() {
        String sql = "select * from sort";
        List<Sort> sortList = null;
        try {
            sortList = qr.query(sql, new BeanListHandler<Sort>(Sort.class));
            for (Sort s : sortList) {
                System.out.println(s);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException("查询失败");
        }
    }
}
