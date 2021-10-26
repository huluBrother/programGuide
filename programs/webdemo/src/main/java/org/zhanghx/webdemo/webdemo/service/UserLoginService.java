package org.zhanghx.webdemo.webdemo.service;

import org.zhanghx.webdemo.webdemo.pojo.Users;

public interface UserLoginService {

    public Users userLogin(String username,String userpwd);
}
