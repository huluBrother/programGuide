package org.zhanghx.webdemo.webdemo.web.filter;

import org.zhanghx.webdemo.webdemo.commons.Constants;
import org.zhanghx.webdemo.webdemo.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"*.do","*.jsp"})
public class UserLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //转换request为HTTP请求
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //获得请求的URI
        String uri = req.getRequestURI();
        System.out.println("请求的URI :" +  uri);

        if( uri.indexOf("login.jsp") != -1 || uri.indexOf("login.do") != -1
                || uri.indexOf("validateCode.do") != -1){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //根据session判断是否登录了信息
            HttpSession session = req.getSession();

            Users user = (Users)session.getAttribute(Constants.USER_SESSION_KEY);
            if(user != null){
                //已经登录了
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                req.setAttribute(Constants.ERROR_MESSAGE,"您还没有进行登录,请先进行登录");
                req.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
