package com.example.mybatis.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-04-19
 * Time: 16:05
 */
@Data
public class UserInfo {
    private Integer id;
    private String name;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private int state;
//    private List<ArticleInfo> artlist;
}