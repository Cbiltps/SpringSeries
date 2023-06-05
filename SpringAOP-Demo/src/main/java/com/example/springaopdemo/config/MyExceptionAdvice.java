package com.example.springaopdemo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-06-06
 * Time: 05:43
 */
//@ControllerAdvice
@RestControllerAdvice // 当前是针对 controller 的通知类(增强类)
public class MyExceptionAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public HashMap<String, Object> ArithmeticExceptionAdvice(ArithmeticException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", -1);
        result.put("data", null);
        result.put("message", "算术异常: " + e.getMessage());
        return result;
    }

    @ExceptionHandler(NullPointerException.class)
    public HashMap<String, Object> nullPointerExceptionAdvice(NullPointerException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", -1);
        result.put("data", null);
        result.put("message", "空指针异常: " + e.getMessage());
        return result;
    }

    @ExceptionHandler(Exception.class)
    public HashMap<String, Object> exceptionAdvice(Exception e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", -1);
        result.put("data", null);
        result.put("message", "异常: " + e.getMessage());
        return result;
    }
}
