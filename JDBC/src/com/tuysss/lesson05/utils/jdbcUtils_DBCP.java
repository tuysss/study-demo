package com.tuysss.lesson05.utils;

import com.tuysss.lesson02.utils.jdbcUtils;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcUtils_DBCP {

    private static DataSource dataSource=null;

    static {
        try {
            InputStream in = jdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);

            //创建数据源 工厂模式：创建对象
            dataSource=BasicDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //从数据源中获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


    //释放连接资源
    public static void realease(Connection connection, Statement statement, ResultSet resultSet)throws SQLException{
        if(resultSet!=null) {
            resultSet.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(connection!=null){
            connection.close();
        }

    }
}
