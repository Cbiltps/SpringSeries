package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: 返回参数/请求转发/请求重定向
 * User: cbiltps
 * Date: 2023-04-10
 * Time: 12:50
 */
@Controller
//@RestController
public class TestController {
    /**
     * ========================================================================
     * 3. 返回参数
     * ========================================================================
     */

    /**
     * 返回静态页面
     * @return
     */
//    @ResponseBody
    @RequestMapping("/sayhi")
    public String sayHi() {
        return "hello.html";
    }

    /**
     * ========================================================================
     *                            请求转发/请求重定向
     *
     *             问很多的面试题: 请求转发和请求重定向有什么区别?
     *             https://juejin.cn/post/7121513633237958670
     * ========================================================================
     */

    /**
     * 请求转发
     * @return
     */
    @RequestMapping("/forward")
    public String myForward() {
        return "forward:/hello.html";
    }

    @RequestMapping("/forward1")
    public String myForward1() {
        return "/hello.html";
    }

    @RequestMapping("/forward2")
    public void myForward2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/hello.html").forward(request, response);
    }

    /**
     * 请求重定向
     * @return
     */
    @RequestMapping("/redirect")
    public String myRedirect() {
        return "redirect:/hello.html";
    }

    @RequestMapping("/redirect2")
    public void myRedirect2(HttpServletResponse response) throws IOException {
        response.sendRedirect("/hello.html");
    }

}