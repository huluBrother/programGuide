package org.zhanghx.webdemo.webdemo.dao;

import org.zhanghx.webdemo.webdemo.pojo.Users;

public interface UserLoginDao {

    public Users selectUsersByUsernameAndUserpwd(String username,String userpwd);
}
