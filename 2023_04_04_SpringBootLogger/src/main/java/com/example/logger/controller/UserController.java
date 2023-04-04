package com.example.logger.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-04-04
 * Time: 13:13
 */
@Controller
@ResponseBody
@Slf4j // 替代了之前需要通过 LoggerFactory.getLogger() 操作
public class UserController {

//    // 1.先得到日志对象(来自 slf4j)
//    private static final Logger log = LoggerFactory.getLogger(UserController.class); // 设置当前类的类型

    @RequestMapping("/logger")
    public void printLog() {
        // 2.使用日志对象提供的打印方法进行日志打印
        log.trace("我是 trace 日志");
        log.debug("我是 debug 日志");
        log.info("我是 info 日志");
        log.warn("我是 warn 日志");
        log.error("我是 error 日志");
    }

}