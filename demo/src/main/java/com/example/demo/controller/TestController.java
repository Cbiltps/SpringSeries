package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lichengxiang
 * Date: 2024-12-20
 * Time: 20:39
 */
@RestController
public class TestController {

    @RequestMapping("/message")
    public int requestTestOfFibonacci(@RequestParam int sendmessage) {
        if (-1 == sendmessage) {
            return -1;
        }
        if (0 == sendmessage) {
            return 0;
        }
        if (sendmessage <= 2) {
            return 1;
        }
        return requestTestOfFibonacci(sendmessage - 2) + requestTestOfFibonacci(sendmessage - 1);
    }
}
