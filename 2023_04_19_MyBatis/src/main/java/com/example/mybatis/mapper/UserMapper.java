package com.example.mybatis.mapper;

import com.example.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-04-19
 * Time: 16:06
 */
@Mapper // mybaits的interface
public interface UserMapper {

//    int delIds(List<Integer> ids);
//
//    int update2(UserInfo userInfo);
//
//    // 根据名称进行模糊查询
//    public List<UserInfo> getListByName(@Param("username") String username);
//
//    // 登录功能
//    public UserInfo login(@Param("username") String username,
//                          @Param("password") String password);

    // 根据用户 id 查询用户
    public UserInfo getUserById(@Param("id") Integer id);

//    // 查询用户及用户发表的所有文章，根据用户id
//    public UserInfo getUserAndArticleByUid(@Param("uid") Integer uid);
//
//    // 根据全名查询用户对象（非模糊查询）
//    public UserInfo getUserByFullName(@Param("username") String username);
//
//    // 获取列表，根据创建时间进行倒序或正序
//    public List<UserInfo> getOrderList(@Param("order") String order);
//
//    // 修改方法【根据id修改名称】
//    public int update(@Param("id") Integer id,
//                      @Param("username") String username);
//
//    // 删除方法
//    public int del(@Param("id") Integer id);
//
//    // 添加用户，返回受影响的行数
//    public int add(UserInfo userInfo);
//
//    // 添加用户，返回受影响的行数和自增的 id
//    public int addGetId(UserInfo userInfo);
//
//    // 添加用户，添加用户时 photo是非必传参数
//    public int add2(UserInfo userInfo);
//
//    // 添加用户，其中 username、password、photo 都是非必传参数，
//    // 但至少会传递一个参数
//    public int add3(UserInfo userInfo);

}