package org.zhanghx.webdemo.webdemo.service;

import org.zhanghx.webdemo.webdemo.pojo.Users;

import java.util.List;

public interface UserManagerService {

    void addUser(Users user);

    List<Users> findUser(Users users);

    Users findUserByUserid(int userid);

    void modifyUser(Users user);

    void dropUser(int userid);
}
