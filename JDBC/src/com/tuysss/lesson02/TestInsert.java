package com.tuysss.lesson02;

import com.tuysss.lesson02.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            conn= jdbcUtils.getConnection();
            st=conn.createStatement();
            String sql="insert into users(id,`NAME`,`PASSWORD`)" +
                    "VALUES(4,'wangli','123455')";
            int i=st.executeUpdate(sql);
            if(i>0){
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.realease(conn,st,rs);
        }

    }
}
