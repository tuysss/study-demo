package com.tuysss.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcUtils {
    private static String driver=null;
    private static String url=null;
    private static String username =null;
    private static String password=null;

    static{
        try {
            Properties properties = new Properties();
            InputStream in = jdbcUtils.class.getClassLoader().getResourceAsStream("src/main/db.properties");
            properties.load(in);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url, username, password);
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if(resultSet!=null){
            resultSet.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(connection!=null){
            resultSet.close();
        }
    }

}
