package org.zhanghx.webdemo.webdemo.web.servlet;

import org.zhanghx.webdemo.webdemo.commons.Constans;
import org.zhanghx.webdemo.webdemo.exception.UserNotFoundException;
import org.zhanghx.webdemo.webdemo.pojo.Users;
import org.zhanghx.webdemo.webdemo.service.UserLoginService;
import org.zhanghx.webdemo.webdemo.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "userLoginServlet",value = "/login.do")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先拿到用户名和密码的请求参数
        String username = req.getParameter("username");
        String userpwd = req.getParameter("userpwd");

        System.out.println("获得参数: username=" + username +" userpwd=" + userpwd);
        try{
            UserLoginService userLoginService = new UserLoginServiceImpl();
            Users users = userLoginService.userLogin(username, userpwd);

            //建立客户端与服务端的会话状态
            HttpSession session = req.getSession();
            session.setAttribute(Constans.USER_SESSION_KEY,users);

            //这里选择重定向，数据有前端操作
            resp.sendRedirect("main.jsp");


        }catch (UserNotFoundException e){
            //用户名或者密码错误,转发到登录界面
            req.getRequestDispatcher("").forward(req,resp);
        }catch (Exception e){
            //不可知的异常
            resp.sendRedirect("error.jsp");
        }
    }
}
