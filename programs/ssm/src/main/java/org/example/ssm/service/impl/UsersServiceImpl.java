package org.example.ssm.service.impl;

import org.example.ssm.exception.UserNotFoundException;
import org.example.ssm.mapper.UsersMapper;
import org.example.ssm.pojo.Users;
import org.example.ssm.pojo.UsersExample;
import org.example.ssm.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users userLogin(Users user) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andUserpwdEqualTo(user.getUserpwd());
        List<Users> users = usersMapper.selectByExample(usersExample);
        if(users == null || users.size() == 0){
            throw  new UserNotFoundException("用户名或者密码错误");
        }
        return users.get(0);
    }
}
