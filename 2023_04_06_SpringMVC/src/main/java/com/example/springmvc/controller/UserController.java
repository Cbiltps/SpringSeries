package com.example.springmvc.controller;

import com.example.springmvc.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

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
@Slf4j
@Controller
@ResponseBody // 表示的是返回一个非静态页面的数据
@RequestMapping("/user") // 类上面的 RequestMapping 可以省略
public class UserController {

    /**
     * ========================================================================
     * 1. 以下都是进行用户和程序的映射
     * ========================================================================
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
     * ========================================================================
     * 2. 以下都是获取用户请求参数
     * ========================================================================
     */

    /**
     * 获取单个参数
     * @param id
     * @return
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
     * 获取对象(不能接受json格式)
     * @param userInfo
     * @return
     */
    @RequestMapping("/register")
    public String register(UserInfo userInfo) {
        return "用户信息: " + userInfo;
    }

    /**
     * 接收 JSON 格式的数据
     * @param userInfo
     * @return
     */
    @RequestMapping("/json")
    public String json(@RequestBody UserInfo userInfo) {
        return "用户信息: " + userInfo;
    }

    /**
     * 从 URL 地址中获取参数(不是从URL地址中的 参数部分 获取参数)
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/hero/{id}/{name}")
    public String getHeroInfo(@PathVariable Integer id, @PathVariable String name) {
        return "ID: " + id + " | Name: " + name;
    }

    // 从配置文件中读取图片的保存路径
    @Value("${img.path}")
    private String imgPath;

    @RequestMapping("/path")
    public String path() {
        return imgPath;
    }

    /**
     * 上传文件
     * @param uid
     * @param file
     * @return
     */
    @RequestMapping("/upimg")
    public boolean upImg(Integer uid, @RequestPart("img") MultipartFile file) {
        boolean result = false;

        // 1. 保存路径(此步骤写到配置文件中)
        // 2. 图片名称(不能重复)-UUID.randomUUID()-可以生成全局唯一的ID
        // 3. 获取上传源图片格式
        String fileName = file.getOriginalFilename(); // 获取源图片名称
        fileName = fileName.substring(fileName.lastIndexOf(".")); // 获取图片格式(后缀)
        fileName = UUID.randomUUID().toString() + fileName;

        // 保存图片到本地目录
        try {
            file.transferTo(new File(imgPath + fileName));
            result = true;
        } catch (IOException e) {
            log.error("上传图片失败: " + e.getMessage());
        }
        return result;
    }

    @RequestMapping("/servlet")
    public String servlet(HttpServletRequest request) {
        return request.getParameter("name");
    }

    /**
     * 以前servlet的方式获取cookie
     * 优点: 获取全部的cookie
     * @param request
     */
    @RequestMapping("/cookie")
    public void getCookie(HttpServletRequest request) {
        // 得到全部的 Cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            log.info("Cookie Name: " + cookie.getName() + " | Cookie Value: " + cookie.getValue());
        }
    }

    /**
     * SpringMVC提供注解获取cookie
     * 优点: 可以获取指定cookie
     * @param cookie
     * @return
     */
    @RequestMapping("/cookie2")
    public String getCookie2(@CookieValue("test") String cookie) {
        return "Cookie Value: " + cookie;
    }

    /**
     * 获取 Header(请求头)里面的信息(servlet写法)
     * @param request
     * @return
     */
    @RequestMapping("/useragent")
    public String getHead(HttpServletRequest request) {
        return "header: " + request.getHeader("User-Agent");
    }

    /**
     * 获取 Header(请求头)里面的信息(SpringMVC写法)
     * @param userAgent
     * @return
     */
    @RequestMapping("/useragent2")
    public String getHead2(@RequestHeader("User-Agent") String userAgent) {
        return "header :" + userAgent;
    }

    /**
     * 存储session
     * @param request
     * @return
     */
    @RequestMapping("/setsession")
    public boolean setSession(HttpServletRequest request) {
        boolean result = false;
        // 1. 创建会话, 并保存必要的身份信息
        HttpSession session = request.getSession(true); // true=如果没有会话，那么创建一个会话
        // 2. 往会话中存储键值对(必要的身份信息)
        session.setAttribute("userinfo", "张三");
        result = true;
        return result;
    }

    @RequestMapping("/getsession")
    public String getSession(HttpServletRequest request) {
        String result = null;
        // 1. 此处 getSession 的参数必须是 false. 前面在登录过程中, 已经创建过会话了. 此处是要直接获取到之前的会话.
        HttpSession session = request.getSession(false);
        // 2. getAttribute 得到 session 信息
        if (session != null && session.getAttribute("userinfo") != null) {
            result = (String) session.getAttribute("userinfo");
        }
        return result;
    }

    @RequestMapping("/getsession2")
    public String getSession2(@SessionAttribute(value = "userinfo", required = false) String userinfo) {
        return "会话: " + userinfo;
    }

    /**
     * 实现登录功能: 前端使用ajax, 后端返回json给前端(普通的参数接收)
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login2")
    public HashMap<String, Object> login2(String username, String password) {
        HashMap<String, Object> result = new HashMap<>();
        int state = 200;
        int data = -1; // 登录成功为1，否则登录失败
        String massage = "未知错误";

        if (StringUtils.hasLength(username) && StringUtils.hasLength(password)) { // 对username和password进行校验(SpringMVC提供方法)
            if (username.equals("admin") && password.equals("admin")) {
                data = 1;
                massage = ""; // 无错误信息
            } else {
                massage = "用户名或密码失败!";
            }
        } else { // 参数为空
            massage = "非法参数";
        }

        result.put("state", state);
        result.put("data", data);
        result.put("massage", massage);
        return result;
    }

    /**
     * 实现登录功能(json接收): 前端使用ajax字符串, 后端返回json给前端
     * @param userInfo
     * @return
     */
    @RequestMapping("/login3")
    public HashMap<String, Object> login3(@RequestBody UserInfo userInfo) { // 接收的是json对象
        HashMap<String, Object> result = new HashMap<>();
        int state = 200;
        int data = -1; // 登录成功为1，否则登录失败
        String massage = "未知错误";

        if (StringUtils.hasLength(userInfo.getUsername()) && StringUtils.hasLength(userInfo.getPassword())) { // 对username和password进行校验(SpringMVC提供方法)
            if (userInfo.getUsername().equals("admin") && userInfo.getPassword().equals("admin")) {
                data = 1;
                massage = ""; // 无错误信息
            } else {
                massage = "用户名或密码失败!";
            }
        } else { // 参数为空
            massage = "非法参数";
        }

        result.put("state", state);
        result.put("data", data);
        result.put("massage", massage);
        return result;
    }

}
