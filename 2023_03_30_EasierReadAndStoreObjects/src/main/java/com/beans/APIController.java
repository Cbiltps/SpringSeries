package com.beans;

import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-30
 * Time: 14:02
 */
@Controller
public class APIController {
    public void sayHi() {
        System.out.println("Hello API Controller!");
    }
}