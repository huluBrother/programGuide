package org.zhanghx.webdemo.webdemo.service.impl;

import org.zhanghx.webdemo.webdemo.dao.UserManagerDao;
import org.zhanghx.webdemo.webdemo.dao.impl.UserManagerDaoImpl;
import org.zhanghx.webdemo.webdemo.pojo.Users;
import org.zhanghx.webdemo.webdemo.service.UserManagerService;

import java.util.List;

public class UserManagerServiceImpl implements UserManagerService {
    @Override
    public void addUser(Users user) {
        UserManagerDao dao = new UserManagerDaoImpl();
        dao.inserUser(user);
    }

    @Override
    public List<Users> findUser(Users users) {
        UserManagerDao dao = new UserManagerDaoImpl();
        List<Users> users1 = dao.selectUsersByProperty(users);
        return users1;
    }

    @Override
    public Users findUserByUserid(int userid) {
        UserManagerDao dao = new UserManagerDaoImpl();
        return dao.selectUserByUserid(userid);
    }

    @Override
    public void modifyUser(Users user) {
        UserManagerDao dao = new UserManagerDaoImpl();
        dao.updateUserByUserid(user);
    }
}
