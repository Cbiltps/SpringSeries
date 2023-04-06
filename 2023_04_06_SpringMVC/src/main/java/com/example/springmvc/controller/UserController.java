package com.example.springmvc.controller;

import com.example.springmvc.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Spring MVC 学习目标:
 *     1、实现用户和程序的映射(在浏览器输入URL地址之后, 能够在程序中匹配到相应方法).
 *     2、服务器端要 得到 用户的请求参数.
 *     3、服务器端要将结果 返回 给用户(前端).
 * User: cbiltps
 * Date: 2023-04-06
 * Time: 06:33
 */
@Controller
@ResponseBody // 表示的是返回一个非静态页面的数据
@RequestMapping("/user") // 类上面的 RequestMapping 可以省略
public class UserController {

    /**
     * 1. 以下都是进行用户和程序的映射
     */

    @RequestMapping("/sayhi")
    public String sayHi() {
        return "你好, 世界1!";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sayhi2")
    public String sayHi2() {
        return "你好, 世界2!";
    }

    /**
     * 只支持 POST 类型的访问方式
     * @return
     */
    @PostMapping("/sayhi3")
    public String sayHi3() {
        return "你好, 世界3!";
    }

    @GetMapping("/sayhi4")
    public String sayHi4() {
        return "你好, 世界4!";
    }


    /**
     * 2. 以下都是获取用户请求参数
     *     2.1 获取单个参数
     */
    @RequestMapping("/getuserbyid")
    public UserInfo getUserById(Integer id) {  // getUserById / findUserById
        /**
         * 上面括号中的参数的tips: 阿里巴巴开发手册规定, 获取参数的时候使用包装类!
         * 举个例子, 前端没有传参数的时候, 如果是int就直接报错; Integer支持null, 不会报错!
         */
        // 不查数据库, 写一个伪代码, 然后返回用户对象
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id == null ? 0 : id); // 前面设置id的时候类型为int, 为null会报错, 所以这样写
        userInfo.setUsername("张三");
        userInfo.setAge(18);
        return userInfo;
        /**
         * tips: 在获取参数之后进行非空效验, 友好的把为空的信息返回给前端(看得懂的), 而不是异常信息(看不懂的)!
         */
    }

    /**
     * 获取多个参数
     * @param username
     * @param password
     * @return
     *
     * tips: 如果在参数中添加 @RequestParam 注解, 前端一定要传递此参数, 否则就会报错，如果想要解决此问题,
     * 可以给 @RequestParam 里面添加 required = false!
     */
    @RequestMapping("/login")
    public String login(@RequestParam(value = "name", required = false) String username, String password) {
        return "用户名: " + username + " | 密码: " + password;
    }

    /**
     * 获取对象
     * @param userInfo
     * @return
     */
    @RequestMapping("/register")
    public String register(UserInfo userInfo) {
        return "用户信息: " + userInfo;
    }
}
