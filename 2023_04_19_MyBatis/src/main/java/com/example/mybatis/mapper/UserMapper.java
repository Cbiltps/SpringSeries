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
@Mapper
public interface UserMapper {

    // 查询用户及用户发表的所有文章
    public UserInfo getUserAndArticleByUid(@Param("uid") Integer uid);

    // 根据名称进行模糊查询
    public List<UserInfo> getListByName(@Param("username") String username);

    // 登录功能
    public UserInfo login(@Param("username") String username, @Param("password") String password);

    // 根据全名查询用户对象(非模糊查询)
    public UserInfo getUserByFullName(@Param("username") String username);

    // 获取列表(根据创建时间进行倒序或正序)
    public List<UserInfo> getOrderList(@Param("order") String order);

    /**
     *  根据用户 id 查询用户:
     *  大部分时候可以不添加 @Param 注解, 在 xml 里用参数命名可以映射,
     *  部分版本问题 xml 里只识别 @Param 中重新命名的参数名.
     * @param id
     * @return
     */
    public UserInfo getUserById(@Param("id") Integer id);

    // 根据用户 id 修改用户名称
    public int update(@Param("id") Integer id, @Param("username") String username); // 这里返回的是受影响的行数

    // 根据用户 id 修改用户数据(动态参数)
    public int update2(UserInfo userInfo); // 这里返回的是受影响的行数

    // 根据用户 id 删除用户
    public int delete(@Param("id") Integer id);

    // 根据多个用户 id 删除用户
    public int deleteWithIds(List<Integer> ids);

    // 添加用户, 返回受影响的行数
    public int add(UserInfo userInfo);

    // 添加用户, 有非必传参数(使用动态参数)
    public int add2(UserInfo userInfo);

    // 添加用户, 有多个非必传参数(使用动态参数)-最少传递一个参数
    public int add3(UserInfo userInfo);

    // 添加用户, 返回受影响的行数和自增的 id
    public int addGetId(UserInfo userInfo);
}