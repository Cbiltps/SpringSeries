package com.example.springaop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-05-29
 * Time: 16:59
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/hi")
    public String sayHi() {
        System.out.println("sayHi 方法: 被执行了!");
        return "hi";
    }

    @RequestMapping("/hello")
    public String sayHello() throws InterruptedException {
        Thread.sleep(250);
        System.out.println("sayHello 方法: 被执行了!");
//        int num = 10 / 0;
        return "hello";
    }

}