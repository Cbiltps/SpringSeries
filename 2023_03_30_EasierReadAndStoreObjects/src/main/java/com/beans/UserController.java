package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-30
 * Time: 13:10
 */
@Controller
public class UserController {

//    @Autowired
//    @Qualifier(value = "user2")
    // 或者是
    @Resource(name = "user2")
    private User user;

    public void sayHi() {
        System.out.println("User -> " + user);
    }

//    public void sayHi() {
//        System.out.println("Hello UserController!");
//    }
}