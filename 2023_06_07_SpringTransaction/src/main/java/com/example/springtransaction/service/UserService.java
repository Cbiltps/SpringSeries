package com.example.springtransaction.service;

import com.example.springtransaction.mapper.UserMapper;
import com.example.springtransaction.model.UserInfo;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-06-07
 * Time: 11:03
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public int add(UserInfo userInfo) {
        return userMapper.add(userInfo);
    }
}
