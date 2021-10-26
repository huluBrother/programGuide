package org.zhanghx.webdemo.webdemo.service.impl;

import org.zhanghx.webdemo.webdemo.dao.UserLoginDao;
import org.zhanghx.webdemo.webdemo.dao.impl.UserLoginDaoImpl;
import org.zhanghx.webdemo.webdemo.exception.UserNotFoundException;
import org.zhanghx.webdemo.webdemo.pojo.Users;
import org.zhanghx.webdemo.webdemo.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {
    @Override
    public Users userLogin(String username, String userpwd) {
        UserLoginDao dao = new UserLoginDaoImpl();
        Users users = dao.selectUsersByUsernameAndUserpwd(username, userpwd);

        if(users == null){
            throw new UserNotFoundException("用户名或者密码错误");
        }
        return users;
    }
}
