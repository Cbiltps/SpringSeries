package com.example.springboot.controller;

import com.example.springboot.model.ReadList;
import com.example.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-04-02
 * Time: 18:19
 */
@Controller
public class UserController {

    @Value("${myyml.string}") // 读取配置项
    private String myymlstr;

    @Value("${server.port}") // 读取配置项
    private String port;

    @Value("${mystring}") // 读取配置项
    private String mystring;

    @Value("${mystring2}") // 读取配置项
    private String mystring2;

    @Value("${mystring3}") // 读取配置项
    private String mystring3;

    @Autowired
    private Student student;

    @Resource
    private ReadList readList;

    @ResponseBody // 返回一个非静态页面的数据
    @RequestMapping("/sayhi") // 设置路由地址
    public String sayHi() {

        /**
         * yml 单/双引号的问题
         */
//        System.out.println("mystring: " + mystring);
//        System.out.println("mystring2: " + mystring2);
//        System.out.println("mystring3: " + mystring3);

//        return "Hello world ! port: " + port + " myymlstr: " + myymlstr;
//        return "student：" + student;
        return "readList：" + readList.getName();
        /**
         * SpringBoot5种读取配置文件的方法:
         * https://juejin.cn/post/7132641888166739982
         */
    }
}