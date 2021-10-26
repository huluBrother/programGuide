package org.zhanghx.webdemo.webdemo.dao.impl;

import org.zhanghx.webdemo.webdemo.commons.JdbcUtils;
import org.zhanghx.webdemo.webdemo.dao.UserManagerDao;
import org.zhanghx.webdemo.webdemo.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Users> selectUsersByProperty(Users user) {
        List<Users>  users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = createSQL(user);
            System.out.println("执行的SQL : " + sql);
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            conn.commit();

            while(rs.next()){
                Users u = new Users();
                u.setUserId(rs.getInt("userid"));
                u.setUsername(rs.getString("username"));
                u.setUserpwd(rs.getString("userpwd"));
                u.setUsersex(rs.getString("usersex"));
                u.setPhonenumber(rs.getString("phonenumber"));
                u.setQqnumber(rs.getString("qqnumber"));

                users.add(u);
            }
            System.out.println("查询到结果行数:" + users.size());
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollback(conn);
        } finally {
            JdbcUtils.closeConnection(conn);
            JdbcUtils.closeStatementAndResult(statement,rs);
        }
        return users;
    }

    @Override
    public Users selectUserByUserid(int userid) {
        Users  users = null;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "select * from users where userid = ?";
            System.out.println("执行的SQL : " + sql);
            statement = conn.prepareStatement(sql);
            statement.setInt(1,userid);
            rs = statement.executeQuery();
            conn.commit();

            while(rs.next()){
                users = new Users();
                users.setUserId(rs.getInt("userid"));
                users.setUsername(rs.getString("username"));
                users.setUserpwd(rs.getString("userpwd"));
                users.setUsersex(rs.getString("usersex"));
                users.setPhonenumber(rs.getString("phonenumber"));
                users.setQqnumber(rs.getString("qqnumber"));
            }
            System.out.println("查询到结果:" + users);
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollback(conn);
        } finally {
            JdbcUtils.closeConnection(conn);
            JdbcUtils.closeStatementAndResult(statement,rs);
        }
        return users;
    }

    @Override
    public void updateUserByUserid(Users user) {
        Connection conn = null;
        PreparedStatement statement = null;
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "update users set username = ?, usersex = ?, phonenumber = ?,qqnumber=?  where userid = ?";

            statement = conn.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getUsersex());
            statement.setString(3,user.getPhonenumber());
            statement.setString(4,user.getQqnumber());
            statement.setInt(5,user.getUserId());
            System.out.println(statement.toString());
            boolean execute = statement.execute();
            conn.commit();

            System.out.println("查询到结果:" + execute);
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollback(conn);
        } finally {
            JdbcUtils.closeConnection(conn);
            JdbcUtils.closeStatement(statement);
        }
    }

    @Override
    public void deleteUserByUserid(int userid) {
        Connection conn = null;
        PreparedStatement statement = null;
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from users where userid=?";

            statement = conn.prepareStatement(sql);
            statement.setInt(1,userid);
            System.out.println(statement.toString());
            boolean execute = statement.execute();
            conn.commit();

            System.out.println("删除的结果:" + execute);
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollback(conn);
        } finally {
            JdbcUtils.closeConnection(conn);
            JdbcUtils.closeStatement(statement);
        }
    }

    private String createSQL(Users user){
        StringBuffer buffer = new StringBuffer("select * from users where 1 = 1 ");

        if(user.getUsername() != null && user.getUsername().length() > 0){
            buffer.append(" and username=").append(user.getUsername());
        }
        if(user.getUserpwd() != null && user.getUserpwd().length() > 0){
            buffer.append(" and userpwd=").append(user.getUserpwd());
        }
        if(user.getUsersex() != null && user.getUsersex().length() > 0){
            buffer.append(" and usersex=").append(user.getUsersex());
        }
        if(user.getPhonenumber() != null && user.getPhonenumber().length() > 0){
            buffer.append(" and phonenumber=").append(user.getPhonenumber());
        }
        if(user.getQqnumber() != null && user.getQqnumber().length() > 0){
            buffer.append(" and qqnumber=").append(user.getQqnumber());
        }


        return buffer.toString();
    }
}
