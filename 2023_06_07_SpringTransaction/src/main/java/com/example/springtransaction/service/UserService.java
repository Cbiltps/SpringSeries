package com.example.springtransaction.service;

import com.example.springtransaction.mapper.LogMapper;
import com.example.springtransaction.mapper.UserMapper;
import com.example.springtransaction.model.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


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

    @Transactional(propagation = Propagation.NESTED)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.REQUIRED)
    public int add(UserInfo userInfo) {
        // 添加用户
        int result = userMapper.add(userInfo);
        System.out.println("添加用户: " + result);
        return result;
    }
}
