package com.beans.scope;

import com.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description: bean的作用域
 * User: cbiltps
 * Date: 2023-04-01
 * Time: 14:26
 */
@Component
public class BeanScope1 {

    @Autowired
    private User user3;

    public User getUser() {
        User user = user3;
        user.setName("悟空");
        return user;
    }
}