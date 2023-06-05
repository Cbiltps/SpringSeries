package com.example.springaopdemo.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-06-06
 * Time: 06:28
 */
@ControllerAdvice
public class MyResponseAdvice implements ResponseBodyAdvice {

    /**
     * 返回一个 boolean 值, true 表示返回数据之前对数据进行重写, 也就是会进入 beforeBodyWrite 方法, 再返回;
     * 如果返回 false 表示对结果不进行任何处理, 直接返回.
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", 1);
        result.put("data", body);
        result.put("message", "");
        return result;
    }
}
