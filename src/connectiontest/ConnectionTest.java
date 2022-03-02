/*import bean.Customer;
import connectiontest.JDBCutils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ResourceBundle;

package connectiontest;

import bean.Customer;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;



import bean.Customer;
import connectiontest.JDBCutils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ResourceBundle;

*//**
 * @author hejinling
 * @create 2022-03-01 16:05
 *//*
public class ConnectionTest {

    @Test
    public void testConnection1() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/atguigu";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","hejinling0323");
        Connection conn = driver.connect(url, info);

        String sql = "update employees set name = ? where employee_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        //填充占位符
        ps.setObject(1,"王菲");
        ps.setObject(2, 100);
        //执行
        ps.execute();
        //资源关闭
        JDBCutils.closeResource(conn,ps);
    }
    @Test
    public void testConnection2() throws IOException, ClassNotFoundException, SQLException {
        //读取配置文件中的四个基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        //InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
        //加载驱动
        Class.forName(driverClass);
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }

    public static void main(String[] args) {
        //使用资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driverClass = bundle.getString("driverClass");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        String url = bundle.getString("url");

        //注册驱动
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(driverClass);
            //获取连接
            conn = DriverManager.getConnection(url, user, password);
            //获取数据库操作对象
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(conn);
    }
    @Test
    //使用工具类实现修改操作
    public void testUpdate() throws Exception {
        //获取数据库连接
        Connection conn = JDBCutils.getConnection();
        //预编译sql语句，获取PrepareStatement实例
        String sql = "update customers set name = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        //填充占位符
        ps.setObject(1,"上发送");
        ps.setObject(2, 3);
        //执行
        ps.execute();
        //资源关闭
        JDBCutils.closeResource(conn,ps);

    }
    @Test
    //select操作
    public void testSelect() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //获取数据库连接
            conn = JDBCutils.getConnection();
            //预编译sql对象，获取PrepareStatement实例
            String sql = "select * from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,4);
            //执行，返回结果集
            ResultSet resultSet = ps.executeQuery();
            //处理结果集
            if(resultSet.next()){

                //获取各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
                //将数据封装到对象中
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCutils.closeResource(conn,ps);
        }
    }
}*/
