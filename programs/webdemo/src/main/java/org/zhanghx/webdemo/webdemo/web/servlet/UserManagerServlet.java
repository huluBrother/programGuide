package org.zhanghx.webdemo.webdemo.web.servlet;

import org.zhanghx.webdemo.webdemo.commons.Constants;
import org.zhanghx.webdemo.webdemo.dao.UserManagerDao;
import org.zhanghx.webdemo.webdemo.pojo.Users;
import org.zhanghx.webdemo.webdemo.service.UserManagerService;
import org.zhanghx.webdemo.webdemo.service.impl.UserManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/usermanager.do")
public class UserManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        System.out.println("接受到新的请求" + flag);
        if("adduser".equals(flag)){
            addUser(req,resp);
            return;
        }else if("findUser".equals(flag)){
            findUser(req,resp);
            return;
        }

        req.setAttribute(Constants.ERROR_MESSAGE,"没有相应的标签操作");
        resp.sendRedirect("error.jsp");
    }


    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Users user = createUser(req);

        try{
            UserManagerService service = new UserManagerServiceImpl();
            service.addUser(user);
            resp.sendRedirect("ok.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }

    }

    private void findUser(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Users user = createUser(req);

        try{
            UserManagerService service = new UserManagerServiceImpl();
            List<Users> list = service.findUser(user);
            req.setAttribute("list",list);


            req.getRequestDispatcher("usermanager/viewUser.jsp").forward(req,resp);

        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }

    }

    private Users createUser(HttpServletRequest req){
        Users user = new Users();
        user.setUsername(req.getParameter("username"));
        user.setUserpwd(req.getParameter("userpwd"));
        user.setUsersex(req.getParameter("usersex"));
        user.setPhonenumber(req.getParameter("phonenumber"));
        user.setQqnumber(req.getParameter("qqnumber"));
        System.out.println(user);
        return user;
    }
}