package com.cheer.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static final DBUtil INSTANCE = new DBUtil();

    public DBUtil(){}

    public static DBUtil getInstance(){
        return INSTANCE;
    }

    public Connection getConnection(){
        Properties properties = this.loadResource();
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String driverClass = properties.getProperty("driverClass");
        Connection connection = null;
        try{
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Properties loadResource(){
        InputStream inputStream = DBUtil.class.getResourceAsStream("/conf/jdbc.properties");
        Properties properties = new Properties();
        try{
            properties.load(inputStream);
        }catch(IOException e){
            e.getStackTrace();
        }
        return properties;
    }

    public void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        if (null != connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != statement){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!= resultSet){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
