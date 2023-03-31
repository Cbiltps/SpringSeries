package com.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-30
 * Time: 14:59
 */
@Component // 加类注解是为了提升性能(减少扫描的范围, 增加框架的加载速度), 告诉spring这里有对象需要储存
public class UserBeans {
    @Bean(name = "user1") //只使用一个 @Bean 是无法将对象存储到容器中的
    public User getUser1() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }

    @Bean(name = {"user2", "userinfo"}) //起两个名字的时候使用大括号即可
    public User getUser2() {
        User user = new User();
        user.setId(2);
        user.setName("李四");
        return user;
    }

    @Bean(name = "user3")
//    @Scope("prototype") // 原型模式
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User getUser3() {
        User user = new User();
        user.setId(1);
        user.setName("Java");
        return user;
    }
}
