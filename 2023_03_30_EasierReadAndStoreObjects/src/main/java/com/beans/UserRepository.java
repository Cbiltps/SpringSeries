package com.beans;

import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-30
 * Time: 13:15
 */
@Repository
public class UserRepository {
    public void sayHi() {
        System.out.println("Hello Repository!");
    }
}