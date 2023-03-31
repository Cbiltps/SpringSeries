package com.beans.inject;

/**
 * Created with IntelliJ IDEA.
 * Description: 根据属性实现 bean 对象的注入
 * User: cbiltps
 * Date: 2023-03-30
 * Time: 17:37
 */

import com.beans.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class Inject1 {

    /**
     * 关于@Autowired 和 @Resource 这是一个非常经典的面试题了!
     * 下去看笔记!
     */
//    @Autowired
    @Resource
    private UserService userService;

    public void sayHi() {
        userService.sayHi();
    }

}