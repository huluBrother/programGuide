package org.zhanghx.webdemo.webdemo.service;

import org.zhanghx.webdemo.webdemo.pojo.Users;

import java.util.List;

public interface UserManagerService {

    void addUser(Users user);

    List<Users> findUser(Users users);
}