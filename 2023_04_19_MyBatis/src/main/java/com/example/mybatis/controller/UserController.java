package com.example.mybatis.controller;

import com.example.mybatis.model.UserInfo;
import com.example.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-04-19
 * Time: 16:08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getuserbyid")
    public UserInfo getUserById(Integer id) {
        if (id == null) {
            return null;
        }
        return userService.getUserById(id);
    }

}