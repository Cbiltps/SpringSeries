package com.example.springaopdemo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-06-03
 * Time: 18:42
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public boolean login(HttpServletRequest request, String username, String password) {
        boolean result = false;
        if (StringUtils.hasLength(username) && StringUtils.hasLength(password)) {
            if (username.equals("admin") && password.equals("admin")) {
                HttpSession session = request.getSession();
                session.setAttribute("userinfo", "userinfo");
                return true;
            }
        }
        return result;
    }

    @RequestMapping("/register")
    public int register() {
        return 1;
    }

    @RequestMapping("/index")
    public String index() {
        int num = 10 / 0;
        return "Hello, Index!";
    }


    @RequestMapping("/index2")
    public String index2() {
        Object obj = null;
        System.out.println(obj.hashCode());
        return "Hello, Index!";
    }

    @RequestMapping("/index3")
    public String index3() {
        String str = "java";
        System.out.println(Integer.valueOf(str));
        return "Hello, Index!";
    }
}
