package base.jdbc.util;

import java.io.FileInputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Properties;

/**
 * @author QX
 * JDBC简易封装类
 */
public class JDBCUtil {
    private String[] queryFields = null;  // 所有的字段
    private Connection connection = null; // 数据库连接对象
    private static String url = null;
    private static String user = null;
    private static String password = null;

    /**
     * @param queryFields 设置待查询的字段
     */
    public void setQueryFields(String[] queryFields) {
        this.queryFields = queryFields;

    }

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\db.properties"));
            String driver = properties.getProperty("driver");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    JDBCUtil(String[] queryFields) throws SQLException {
        this.queryFields = queryFields;
        this.connection = DriverManager.getConnection(url, user, password);
    }

    private PreparedStatement getPreStatement(String sql, Object... params) {
        int cnt = 0;
        for (int i = 0; i < sql.length(); i++) {
            if (sql.charAt(i) == '?') {
                cnt++;
            }
        }
        if (cnt != params.length || params.length > this.queryFields.length) {
            return null;
        }

        PreparedStatement preStatement = null; // 预编译sql执行对象
        try {
            preStatement = this.connection.prepareStatement(sql);
            for (int i = 1; i <= cnt; i++) {
                preStatement.setObject(i, params[i - 1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return preStatement;
    }

    /**
     * @param sql    待执行的sql语句
     * @param params ?对应的参数
     * @return 更新数据的总数
     * @throws SQLException SQL执行异常
     */
    public int update(String sql, Object... params) throws SQLException {
        PreparedStatement preStatement = getPreStatement(sql, params);
        assert preStatement != null;
        int ret = preStatement.executeUpdate();
        release(preStatement, null);
        return ret;
    }


    /**
     * @param sql    待执行的sql语句
     * @param params ?对应的参数
     * @return 查询的结果
     * @throws SQLException SQL执行异常
     */
    public LinkedList<HashMap<String, Object>> query(String sql, Object... params) throws SQLException {
        PreparedStatement preStatement = getPreStatement(sql, params);
        assert preStatement != null;
        ResultSet resultSet = preStatement.executeQuery();
        LinkedList<HashMap<String, Object>> allRecords = new LinkedList<>();
        // LinkedHashMap为有序集合，可以保证记录的顺序，与数据库的显示一致
        while (resultSet.next()) {
            HashMap<String, Object> oneRecordMap = new LinkedHashMap<>();  // 一条记录
            for (String field : this.queryFields) {
                Object value = resultSet.getObject(field);
                oneRecordMap.put(field, value);
            }
            allRecords.add(oneRecordMap);
        }
        release(preStatement, resultSet);
        return allRecords;
    }

    /**
     * 开启事务
     */
    public void setAutoCommit(boolean isAuto) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.setAutoCommit(isAuto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 提交
     */
    public void commit() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚
     */
    public void rollback() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    private void release(PreparedStatement pre, ResultSet res) {
        try {
            if (pre != null) {
                pre.close();
            }
            if (res != null) {
                res.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 关闭连接
     */
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
