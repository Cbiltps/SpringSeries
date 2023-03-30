package com.beans;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-30
 * Time: 13:13
 */
@Service
public class UserService {
    public void sayHi() {
        System.out.println("Hello Service!");
    }
}