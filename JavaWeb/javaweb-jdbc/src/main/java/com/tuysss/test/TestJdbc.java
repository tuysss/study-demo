package com.tuysss.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.tuysss.utils.*;

public class TestJdbc {

    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        connection=jdbcUtils.getConnection();
        statement=connection.createStatement();

        String sql="SELECT * FROM jdbc.users";
        resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("name"));
            System.out.println("password="+resultSet.getObject("password"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birthday="+resultSet.getObject("birthday"));
            System.out.println("=====================================");

        }

        jdbcUtils.release(connection,statement,resultSet);

    }

}
