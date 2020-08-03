package base.jdbc.simple;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
jdbc.driverClass   = com.mysql.cj.jdbc.Driver
jdbc.url = jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT
jdbc.username = root
jdbc.password = root123


 */
public class Demo {
    @Test
    public void main() throws ClassNotFoundException, SQLException{
        //注册驱动（导入jar包）该jar包版本会自动注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/production?&serverTimezone=GMT", "root", "root");
        //获取执行静态sql语句的对象
        Statement statement = connection.createStatement();
        //定义sql语句
        String sql = "update users set dpt_id = 2 where id = 15";
        //执行DQL\DML sql语句，executeUpdate返回值为表操作的总记录数
        int ret = statement.executeUpdate(sql);
        System.out.println(ret);
        String[] fields = new String[]{"id", "name", "age"};
        sql = "select id,?,age from users where id < ?";
        PreparedStatement preStatement = connection.prepareStatement(sql);
        preStatement.setString(1, "name");
        preStatement.setInt(2, 6);
//        preStatement.setString(3,"age");
        ResultSet resultSet = preStatement.executeQuery(); // 预编译sql执行对象
        while (resultSet.next()) {
            StringBuilder oneRecord = new StringBuilder();
            for (var field : fields) {
                String value = resultSet.getString(field);
                oneRecord.append(field).append(":").append(value);
            }
            System.out.println(oneRecord);
        }
        ResultSet res = statement.executeQuery(sql);
        String[] allFields = new String[]{"id", "name", "age", "sex", "money", "dpt_id", "create_time", "update_time"};
        while (res.next()) {
            StringBuilder oneRecord = new StringBuilder();
            for (var field : allFields) {
                String value = res.getString(field);
                oneRecord.append(field).append(":").append(value);
            }
            System.out.println(oneRecord);
        }

        //释放资源
        statement.close();
        connection.close();
        res.close();
    }
}
