package org.zhanghx.webdemo.webdemo.web.listener;


import org.zhanghx.webdemo.webdemo.commons.Constants;
import org.zhanghx.webdemo.webdemo.pojo.Users;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class HttpSessionLifeCycleListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        Users user = (Users)session.getAttribute(Constants.USER_SESSION_KEY);
        ServletContext servletContext = session.getServletContext();
        servletContext.removeAttribute(Integer.valueOf(user.getUserId()).toString());

    }
}
