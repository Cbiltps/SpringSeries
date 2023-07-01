package com.example.springtransaction.controller;

import com.example.springtransaction.model.UserInfo;
import com.example.springtransaction.service.UserService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-06-07
 * Time: 11:00
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private DataSourceTransactionManager transactionManager; // 事务管理器

    @Resource
    private TransactionDefinition transactionDefinition; // 事务定义

    /**
     * 添加用户操作(在此方法中使用编程式的事务)
     * @param userInfo
     * @return
     */
    @RequestMapping("/add")
    public int add(UserInfo userInfo) {
        // 非空效验(验证用户名和密码不为空)
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername()) || !StringUtils.hasLength(userInfo.getPassword())) {
            return 0;
        }

        // 获取事务(开启事务)
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

        int result = userService.add(userInfo);
        System.out.println("受影响的行数: " + result);

        // 回滚事务
//        transactionManager.rollback(transactionStatus);
        // 提交事务
        transactionManager.commit(transactionStatus);

        return result;
    }

    /**
     * 添加用户操作(在此方法中使用声明式事务)
     *
     * 既添加 @Transactional 注解:
     *     在方法执行之前, 自动开启事务;
     *     在方法执行完之后, 自动提交事务;
     *     如果出现异常, 自动回滚事务!
     *
     * 注意: @Transactional 可以添加很多参数, 看课件(代码就不多写了)!
     * @param userInfo
     * @return
     */
    @Transactional
    @RequestMapping("/add2")
    public int add2(UserInfo userInfo) {
        // 非空效验(验证用户名和密码不为空)
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername()) || !StringUtils.hasLength(userInfo.getPassword())) {
            return 0;
        }
        int result = userService.add(userInfo);
        System.out.println("受影响的行数: " + result);

        int num = 10 / 0; // 添加一个异常看看声明式事务是否自动回滚!

        return result;
    }

    /**
     * 使用了 @Transactional 注解, 在异常被捕获的情况下, 不会进行事务自动回滚!!!
     * @param userInfo
     * @return
     */
    @Transactional
    @RequestMapping("/add3")
    public int add3(UserInfo userInfo) {
        // 非空效验(验证用户名和密码不为空)
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername()) || !StringUtils.hasLength(userInfo.getPassword())) {
            return 0;
        }
        int result = userService.add(userInfo);
        System.out.println("受影响的行数: " + result);

        try {
            int num = 10 / 0; // 添加一个异常看看声明式事务是否自动回滚!
        } catch (Exception e) {
            /**
             * 运行之后, 发现数据库中的数据没有回滚!
             * 系统认为你有自己的解决方案!
             */

            // 结局方法:
//            throw e; // 把异常又扔出去, 简单粗暴

            // 优雅的解决方式:
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); // 使用代码的方式手动回滚
        }

        return result;
    }
}
