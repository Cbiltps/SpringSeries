package com.example.mybatis.mapper;

import com.example.mybatis.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-04-20
 * Time: 07:22
 */
@SpringBootTest // 表示当前单元测试运行在 spring boot 环境中
@Slf4j
class UserMapperTest {

//    @Autowired // 科学版的 idea 此行代码会报错
    @Resource
    private UserMapper userMapper;

    @Test
    void getUserById() {
        UserInfo userInfo = userMapper.getUserById(1);
        Assertions.assertNotNull(userInfo);
    }

    /**
     * 关于 @Transactional 的 tips:
     * 上面其实就是执行了sql但是没有提交, 然后直接回滚.
     * 但是mysql里执行的时候就直接添加了呢?
     *     是因为mysql开启了自动提交!
     */
    @Test
    @Transactional // 在单元测试中添加事务注解, 表示在方法执行完之后回滚事务, 这样数据库就不会被污染了
    void update() {
        int result = userMapper.update(2, "老三");
        Assertions.assertEquals(1, result); // 返回的是受影响的行数, 受影响的行数应该是'1', 不是'1'则断言报错
    }

    @Test
    @Transactional
    void delete() {
        int result = userMapper.delete(2);
        System.out.println("受影响的行数: " + result);
        Assertions.assertEquals(1, result);
    }

    @Test
    void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("王五");
        userInfo.setPassword("123");
        userInfo.setPhoto("default.png");
        int result = userMapper.add(userInfo);
        System.out.println("添加的结果: " + result);
        Assertions.assertEquals(1, result);
    }

    @Test
    void addGetId() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("李四");
        userInfo.setPassword("123");
        userInfo.setPhoto("default.png");
        System.out.println("添加之前 user id: " + userInfo.getId());
        int result = userMapper.addGetId(userInfo);
        System.out.println("受影响的行数: " + result);
        System.out.println("添加之后 user id: " + userInfo.getId());
        Assertions.assertEquals(1, result);
    }
}