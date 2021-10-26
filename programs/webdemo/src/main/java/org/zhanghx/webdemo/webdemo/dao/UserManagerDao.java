package org.zhanghx.webdemo.webdemo.dao;

import org.zhanghx.webdemo.webdemo.pojo.Users;

import java.util.List;

public interface UserManagerDao {
    void inserUser(Users user);

    List<Users> selectUsersByProperty(Users user);
}
