package com.tuysss.lesson01;

import java.sql.*;
import java.util.Collections;

public class jdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.用户信息和url
        String url="jdbc:mysql://localhost:3306/jdbcstudy" +
                "?useUnicode&characterEncoding=utf8&useSSL=false";
        String username="root";
        String password="123456";

        //3.连接成功，connection代表数据库对象
        Connection connection=DriverManager.getConnection(url,username,password);

        //4. 执行SQL对象
        Statement statement = connection.createStatement();

        //5.执行SQL的对象，执行SQL可能存在结果，查看返回结果
        String sql="SELECT * FROM jdbcstudy.users ";

        //返回的结果集，其中封装了全部查询出的结果
        ResultSet resultset=statement.executeQuery(sql);

        while(resultset.next()){
            System.out.println("id="+resultset.getObject("id"));
            System.out.println("name="+resultset.getObject("NAME"));
            System.out.println("password="+resultset.getObject("PASSWORD"));
            System.out.println("email="+resultset.getObject("email"));
            System.out.println("birthday="+resultset.getObject("birthday"));
            System.out.println("=======================================");
        }
        //6.释放连接
        resultset.close();
        statement.close();
        connection.close();

    }
}
