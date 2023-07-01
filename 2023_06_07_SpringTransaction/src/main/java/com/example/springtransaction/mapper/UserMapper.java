package com.example.springtransaction.mapper;

import com.example.springtransaction.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-06-07
 * Time: 11:02
 */
@Mapper
public interface UserMapper {
    int add(UserInfo userInfo);
}
