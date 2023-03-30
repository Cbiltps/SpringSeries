package com.beans;

import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-30
 * Time: 13:24
 */
//@Configurable //注意不是此注解
@Configuration
public class UserConfig {
    public void sayHi() {
        System.out.println("Hello Config!");
    }
}