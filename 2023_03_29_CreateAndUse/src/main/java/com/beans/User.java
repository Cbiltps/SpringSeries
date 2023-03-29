package com.beans;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-29
 * Time: 21:11
 */
public class User {
    public User() {
        System.out.println("加载了User!");
    }

    public void sayHi(String name) {
        System.out.println("Hello: " + name);
    }
}
