package org.zhanghx.webdemo.webdemo.web.servlet;

import org.zhanghx.webdemo.webdemo.commons.Constants;
import org.zhanghx.webdemo.webdemo.exception.UserNotFoundException;
import org.zhanghx.webdemo.webdemo.pojo.Users;
import org.zhanghx.webdemo.webdemo.service.UserLoginService;
import org.zhanghx.webdemo.webdemo.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletContext;
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
        String code = req.getParameter("code");
        
        System.out.println("获得参数: username=" + username +" userpwd=" + userpwd);
        try{
            //建立客户端与服务端的会话状态
            HttpSession session = req.getSession();

            String checkCode = (String)session.getAttribute(Constants.VALIDATE_CODE_KEY);

            if(checkCode.equals(code)){

                UserLoginService userLoginService = new UserLoginServiceImpl();
                Users users = userLoginService.userLogin(username, userpwd);


                session.setAttribute(Constants.USER_SESSION_KEY,users);

                //判断是否已经存在了登录的会话
                ServletContext servletContext = this.getServletContext();
                HttpSession lastSession = (HttpSession)servletContext.getAttribute(Integer.valueOf(users.getUserId()).toString());
                if(lastSession != null){
                    System.out.println("已经存在会话,将移除sessionID=" + lastSession.getId());
                    servletContext.removeAttribute(Integer.valueOf(users.getUserId()).toString());
                    lastSession.invalidate();
                }

                //将session保存到全局容器(这里的key使用了user的ID,有点草率)
                servletContext.setAttribute(Integer.valueOf(users.getUserId()).toString(),session);

                //这里选择重定向，数据有前端操作
                resp.sendRedirect("main.jsp");
            }else{
                req.setAttribute(Constants.ERROR_MESSAGE,"验证码有误，请重新输入");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }


        }catch (UserNotFoundException e){
            e.printStackTrace();
            //用户名或者密码错误,转发到登录界面
            req.setAttribute(Constants.ERROR_MESSAGE,e.getMessage());
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            //不可知的异常
            resp.sendRedirect("error.jsp");
        }
    }
}
