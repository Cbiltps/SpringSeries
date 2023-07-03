package com.example.springtransaction.model;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-07-01
 * Time: 18:02
 */
import lombok.Data;

@Data
public class LogInfo {
    private int id;
    private String name;
    private String desc;
    private String createtime;
}