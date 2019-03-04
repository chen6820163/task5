package com.jnshu.task4.web.interceptor;


import com.jnshu.task4.common.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 对涉及到需要超级用户的操作，进行登录拦截，
 * 未登录则让页面跳转至登录界面
 *
 * @author
 * @phone 18779411728
 * @date 2018/8/2
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {     //用户不存在，页面跳转至登录界面
            try {
                response.sendRedirect("/u/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                filterChain.doFilter(servletRequest,servletResponse);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
