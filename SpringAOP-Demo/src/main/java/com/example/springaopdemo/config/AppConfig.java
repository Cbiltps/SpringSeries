package com.example.springaopdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-06-03
 * Time: 18:26
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private LoginIntercept loginIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginIntercept)
//                .addPathPatterns("/**") // 拦截所有的url
//                .excludePathPatterns("/user/login") // 不拦截登录接口
//                .excludePathPatterns("/user/register")
//                .excludePathPatterns("/login.html") // 不拦截登录页面
//                .excludePathPatterns("/register.html")
//                .excludePathPatterns("/**/*.js") // 不拦截js文件
//                .excludePathPatterns("/**/*.css")
//                .excludePathPatterns("/**/*.png")
//                .excludePathPatterns("/**/*.jpg");
    }

    /**
     * 所有的接口添加 api 前缀
     * @param configurer
     */
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        // 其中第二个参数是一个表达式, 设置为 true 表示启动前缀
//        configurer.addPathPrefix("api", c -> true);
//    }
}
