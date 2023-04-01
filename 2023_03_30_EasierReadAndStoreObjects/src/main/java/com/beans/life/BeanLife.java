package com.beans.life;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-04-01
 * Time: 15:33
 */
//@Component // 已经在spring_config.xml文件中注入了, 写注解就会执行两次
public class BeanLife implements BeanNameAware {

    @PostConstruct
    public void postConstruct() {
        System.out.println("执行 @PostConstruct");
    }

    public void init() {
        System.out.println("执行 init-method");
    }

    public void use() {
        System.out.println("使用 bean");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("执行了 @PreDestroy");
    }

    public void setBeanName(String s) {
        System.out.println("执行了 Aware 通知");
    }
}
