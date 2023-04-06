package com.example.springmvc.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-04-06
 * Time: 06:53
 */
@Data
public class UserInfo {
    private int id;
    private String username;
    private String password;
    private int age;
    // ...
}
