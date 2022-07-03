package com.tuysss.lesson04;

import com.tuysss.lesson02.utils.jdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
事务
 */
public class TestTransaction1 {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        try {
            conn=jdbcUtils.getConnection();
            //关闭数据库的自动提交，会自动开启
            conn.setAutoCommit(false);

            String sql1="update account set money=money-100 where name='A'";
            st=conn.prepareStatement(sql1);
            st.executeUpdate();

            String sql2="update account set money=money+100 where name='B'";
            st=conn.prepareStatement(sql2);
            st.executeUpdate();

            //业务完毕，提交事务
            conn.commit();
            System.out.println("成功");

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();  //如果失败，回滚事务
            }
            e.printStackTrace();
        } finally{
            jdbcUtils.realease(conn,st,rs);
        }

    }
}
