package com.beans.inject;

/**
 * Created with IntelliJ IDEA.
 * Description: 使用构造方法实现 bean 注入
 * User: cbiltps
 * Date: 2023-03-30
 * Time: 17:57
 */

import com.beans.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class Inject2 {

    private UserService userService;

    // 构造方法注入（官方推荐写法）
    // 这里有两个注意点:
    //     1: 当类里面只有一个构造方法的时候, @Autowired 是可以不写的,
    //        但是, 有多个注解的时候不写 @Autowired 就会报错!
    //     2: 构造方法注入不能使用 @Resource 注解!!!
    @Autowired
//    @Resource // error
    public Inject2(UserService userService) {
//        userService = new UserService(); // 传统的写法
        this.userService = userService;
    }

    public Inject2(UserService userService, int num) {
        this.userService = userService;
    }

    public void sayHi() {
        userService.sayHi();
    }

}