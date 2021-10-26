package org.zhanghx.webdemo.webdemo.service.impl;

import org.zhanghx.webdemo.webdemo.dao.UserManagerDao;
import org.zhanghx.webdemo.webdemo.dao.impl.UserManagerDaoImpl;
import org.zhanghx.webdemo.webdemo.pojo.Users;
import org.zhanghx.webdemo.webdemo.service.UserManagerService;

public class UserManagerServiceImpl implements UserManagerService {
    @Override
    public void addUser(Users user) {
        UserManagerDao dao = new UserManagerDaoImpl();
        dao.inserUser(user);
    }
}
