package com.tuysss.lesson03;

import com.tuysss.lesson02.utils.jdbcUtils;

import java.sql.*;

public class TestInsert {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        try {
            conn= jdbcUtils.getConnection();

            //PrePareStatement区别:
            //使用？占位符代表参数
            String sql="insert into users(id,`NAME`,`PASSWORD`,`birthday`) VALUES(?,?,?,?)";
            //预编译SQL,先写sql，然后不执行
            st=conn.prepareStatement(sql);
            //手动给参数赋值
            st.setInt(1,4);
            st.setString(2,"liunai");
            st.setString(3,"112233");
            //注意：sql.Date   数据库
            //     util.Date   Java
            st.setDate(4,new java.sql.Date(new Date(2000,5,13).getTime()));

            int i=st.executeUpdate();
            if(i>0){
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.realease(conn,st,null);
        }

    }
}
