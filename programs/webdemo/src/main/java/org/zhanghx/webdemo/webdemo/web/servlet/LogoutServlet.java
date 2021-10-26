package org.zhanghx.webdemo.webdemo.web.servlet;

import org.zhanghx.webdemo.webdemo.commons.Constants;
import org.zhanghx.webdemo.webdemo.pojo.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Users user = (Users)session.getAttribute(Constants.USER_SESSION_KEY);
        session.getServletContext().removeAttribute(Integer.valueOf(user.getUserId()).toString());
        session.invalidate();
        resp.sendRedirect("login.jsp");
    }
}
