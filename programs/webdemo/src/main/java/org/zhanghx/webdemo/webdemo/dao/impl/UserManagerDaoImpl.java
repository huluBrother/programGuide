package org.zhanghx.webdemo.webdemo.dao.impl;

import org.zhanghx.webdemo.webdemo.commons.JdbcUtils;
import org.zhanghx.webdemo.webdemo.dao.UserManagerDao;
import org.zhanghx.webdemo.webdemo.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserManagerDaoImpl implements UserManagerDao {
    @Override
    public void inserUser(Users user) {
        Connection conn = null;
        PreparedStatement statement = null;
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);

            String sql = "INSERT INTO users (userid,username,userpwd,usersex,phonenumber,qqnumber) VALUES (DEFAULT,?,?,?,?,?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getUserpwd());
            statement.setString(3,user.getUsersex());
            statement.setString(4,user.getPhonenumber());
            statement.setString(5, user.getQqnumber());
            boolean res = statement.execute();
            System.out.println("插入结果 " + res);
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollback(conn);
        } finally {
            JdbcUtils.closeConnection(conn);
            JdbcUtils.closeStatement(statement);
        }
    }
}
