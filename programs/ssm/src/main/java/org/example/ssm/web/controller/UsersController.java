package org.example.ssm.web.controller;


import org.example.ssm.pojo.Users;
import org.example.ssm.pojo.UsersExt;
import org.example.ssm.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @RequestMapping("/userlogin")
    public String userLogin(UsersExt users, HttpServletRequest request){
        users.setIp(request.getRemoteAddr());
        this.usersService.userLogin(users);
        request.getSession().setAttribute("user",users);
        return "redirect:/page/index";
    }
}
