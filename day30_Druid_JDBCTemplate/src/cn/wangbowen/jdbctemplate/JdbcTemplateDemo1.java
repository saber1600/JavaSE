package cn.wangbowen.jdbctemplate;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/*
JdbcTemplate入门
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {

        // 导入jar包（5个）
        // 创建JdbcTemplate对象，参数传一个数据源
        JdbcTemplate template = new JdbcTemplate(/*这里加一个DateSource*/);
        // 调用方法(示范例子，以下代码并不能运行)
        String sql = "......... ?,?,?";

        //* 更新操作
        int row = template.update(sql, 1, 2, 3);

        // 查询结果封装为Map集合(一条记录！，并将字段名和值组成键值对)
        // *用于返回一条记录的时候
        Map<String, Object> map = template.queryForMap(sql, 1, 2);

        // 查询多条记录，封装为List集合
        // 将每个记录，封装Map后。添加到List中
        List<Map<String, Object>> mapList = template.queryForList(sql, 12);

        //* 将返回数据直接封装成JavaBean对象
        List<Object/*JavaBean类名*/> query = template.query(sql, new BeanPropertyRowMapper</*javaBean类名*/>(/*JavaBean.class*/));

        //* 返回一个数据（如聚合函数）。参数是返回的类型的Class
        Long aLong = template.queryForObject(sql, Long.class);


    }
}
