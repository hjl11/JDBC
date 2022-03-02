package hejinling.exer1;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 从控制台向数据库的表customers中插入一条数据
 * @author hejinling
 * @create 2022-03-02 13:07
 */
public class Exer1 {
    @Test
    public void test1() throws Exception {
        //加载配置文件,读取配置信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");


        //注册驱动
        Class.forName(driverClass);
        //获取数据库连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
        //预编译sql语句,获取PreparedStatement实例
        String sql = "insert into customers(id,name,email,birth) values (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        //填充占位符
        ps.setObject(1,50);
        ps.setObject(2,"何");
        ps.setObject(3,"hjl980323@163.com");
        ps.setObject(4,"1998-03-23");
        //执行sql语句
        boolean execute = ps.execute();
        System.out.println(execute);

    }
}
