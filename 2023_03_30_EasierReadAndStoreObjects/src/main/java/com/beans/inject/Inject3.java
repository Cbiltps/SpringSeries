package com.beans.inject;

/**
 * Created with IntelliJ IDEA.
 * Description: 使用 Setter 实现 bean 注入
 * User: cbiltps
 * Date: 2023-03-30
 * Time: 18:08
 */

import com.beans.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class Inject3 {

    private UserService userService;

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void sayHi() {
        userService.sayHi();
    }

}