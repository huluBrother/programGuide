package org.zhanghx.webdemo.webdemo.commons;

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcUtils {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {

        try {
            //读取资源文件，获得数据库的连接信息
            ResourceBundle db = ResourceBundle.getBundle("db");
            driver = db.getString("driver");
            url = db.getString("url");
            username = db.getString("username");
            password = db.getString("password");

            //加载数据库驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //声明一个获取数据库连接的方法
    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeStatementAndResult(Statement statement, ResultSet rs) {

        try {
            if (statement != null) {
                statement.close();
            }
            if(rs != null){
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
