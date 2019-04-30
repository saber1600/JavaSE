public class preView {
    /*
        1.各大厂家的连接池必须要实现javax.sql.DateSource 接口
        2.需要2个包dbcp和pool。与mysql驱动和dbutils工具包一起配合使用

        3.使用过程：
            ·首先还是要自己写一个工具类，里面定义一个数据源对象，这个对象是连接池厂商提供的，即第1点
                【原来是一个Connection，现在变成数据源而已】
            ·进行连接池的配置（可以用配置文件，也可以手写，推荐配置文件）
                【必要的4个配置驱动、url、user、password，有的连接池会自动识别驱动
                    可选的：InitialSize初始化连接数、
                            MaxActive最大连接数量、
                            MaxIdle最大空闲数、
                            MinIdle最小空闲数
                】
            ·定义一个返回数据源的方法，返回值是数据源，方便下面【】中QueryRunner的构造
            ·调用数据源的getConnection方法
                【用commons-dbutils中的QueryRunner时候，构造方法如果是DateSource接口的实现类，后续的
                    query和update方法，就不用传第一个参数Connection了
                】
     */
}
