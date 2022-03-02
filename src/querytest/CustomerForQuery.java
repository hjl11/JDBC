package querytest;

import bean.Customer;
import connectiontest.JDBCutils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author hejinling
 * @create 2022-03-01 21:29
 */
public class CustomerForQuery {
    public Customer queryForCustomers(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCutils.getConnection();


            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            int cc = rsmd.getColumnCount();
            if(rs.next()){
                Customer cust = new Customer();
                for (int i = 0; i < cc; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //获取每个列的别名，注意不要用列名，因为当类的属性名和数据库中的字段名不一致的时候会产生错误
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    Field field = Customer.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(cust,columnValue);

                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutils.closeResource(conn,ps,rs);
        }

        return null;
    }
    @Test
    public void testQueryForCustomers(){
        String sql = "select id,name,birth,email from customers where id = ?";

        Customer customer = queryForCustomers(sql, 2);
        System.out.println(customer);
    }

}
