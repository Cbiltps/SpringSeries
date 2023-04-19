package com.example.mybatis.service;

import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-04-19
 * Time: 16:08
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public UserInfo getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

}