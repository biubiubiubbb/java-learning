package base.jdbc.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

public class UtilTest {
    @Test
    public void queryTest() {
        JDBCUtil demo = null;
        try {
            demo = new JDBCUtil(new String[]{"id", "name", "age", "sex", "money", "dpt_id", "phone", "update_time"});
            demo.setAutoCommit(false);
            demo.setQueryFields(new String[]{"id", "name", "age", "sex", "money", "dpt_id"}); // 设置要查询的字段
            String sql = "select * from users where id < ? and sex = ?";
            LinkedList<HashMap<String, Object>> result = demo.query(sql, 7, "男");
            for (var oneRecordMap : result) {
                System.out.println(oneRecordMap);
            }
            demo.commit();
        } catch (Exception e) {
            demo.rollback();
            e.printStackTrace();
        } finally {
            demo.close();
        }
    }

    @Test
    public void updateTest() {
        JDBCUtil demo = null;
        try {
            demo = new JDBCUtil(new String[]{"id", "name", "age", "sex", "money", "dpt_id", "phone", "update_time"});
            demo.setAutoCommit(false);
            String sql = "update users set dpt_id = ?, money = ?";
            System.out.println(demo.update(sql, 2, 50.8));
            demo.commit();
        } catch (Exception e) {
            demo.rollback();
            e.printStackTrace();
        } finally {
            demo.close();
        }
    }
}
