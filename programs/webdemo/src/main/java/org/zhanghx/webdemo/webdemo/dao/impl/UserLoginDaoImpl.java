package org.zhanghx.webdemo.webdemo.dao.impl;

import org.zhanghx.webdemo.webdemo.commons.JdbcUtils;
import org.zhanghx.webdemo.webdemo.dao.UserLoginDao;
import org.zhanghx.webdemo.webdemo.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDaoImpl implements UserLoginDao {
    @Override
    public Users selectUsersByUsernameAndUserpwd(String username, String userpwd) {
        Users user = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            preparedStatement = conn.prepareStatement("select * from users where username = ? and userpwd = ?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,userpwd);
            rs = preparedStatement.executeQuery();

            while(rs.next()){
                user = new Users();
                user.setUserId(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setUserpwd(rs.getString("userpwd"));
                user.setUsersex(rs.getString("usersex"));
                user.setPhonenumber(rs.getString("phonenumber"));
                user.setQqnumber(rs.getString("qqnumber"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
            JdbcUtils.closeStatementAndResult(preparedStatement,rs);
        }


        return user;
    }
}
