package com.example.springboot.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-04-03
 * Time: 17:05
 */
@Data
@ConfigurationProperties(prefix = "student2") // 读取配置文件中的对象
@Component // 不能省略
public class Student {
    private int id;
    private String name;
    private int age;
}