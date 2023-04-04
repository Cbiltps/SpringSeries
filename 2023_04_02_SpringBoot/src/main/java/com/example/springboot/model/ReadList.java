package com.example.springboot.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-04-03
 * Time: 17:03
 */
@Component
@Data
@ConfigurationProperties("dbtypes") // 读取配置文件中集合
public class ReadList {
    private List<String> name;
}