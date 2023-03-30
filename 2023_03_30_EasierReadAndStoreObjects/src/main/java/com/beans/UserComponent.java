package com.beans;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-30
 * Time: 13:25
 */
@Component
public class UserComponent {
    public void sayHi() {
        System.out.println("Hello Component!");
    }
}