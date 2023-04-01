package com.beans.scope;

import com.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-04-01
 * Time: 14:30
 */
@Component
public class BeanScope2 {

    @Autowired
    private User user3;

    public User getUser() {
        return user3;
    }
}