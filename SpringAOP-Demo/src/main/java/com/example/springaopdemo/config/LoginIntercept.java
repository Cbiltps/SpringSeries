package com.example.springaopdemo.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description: 自定义用户登录的拦截器
 * User: cbiltps
 * Date: 2023-06-03
 * Time: 18:15
 */
@Component
public class LoginIntercept implements HandlerInterceptor {

    /**
     * 返回 true 表示拦截判断通过, 可以访问后面的接口;
     * 如果返回 false 表示拦截未通过, 直接返回结果给前端!
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 得到 HttpSession 对象
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userinfo") == null) {
            // 执行到此行代码表示未登录, 未登录就跳转到登录页面
            response.sendRedirect("/login.html");
            return false;
        }
        // 表示已经登录
        return true;
    }
}
