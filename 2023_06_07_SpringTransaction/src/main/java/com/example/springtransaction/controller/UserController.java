package com.example.springtransaction.controller;

import com.example.springtransaction.model.LogInfo;
import com.example.springtransaction.model.UserInfo;
import com.example.springtransaction.service.LogService;
import com.example.springtransaction.service.UserService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
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
    private LogService logService;

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


    /**
     * 默认的事务隔离级别就是 REQUIRED ,所以加不加 propagation = Propagation.REQUIRED 都是一样的!
     *
     * 注意: 正常写业务的时候, 添加用户和日志信息写在一起是可以的,
     * 但是, 这里要验证的是 事务A中调用了B和C事务 ,
     * 所以, 这里要学三个方法,
     * 故此, 要把 添加用户和日志信息 分开写!
     *
     * 设置添加用户正常, 添加日志异常, 最后运行代码, 浏览器尝试添加操作:
     * 发现, 添加的用户也被回滚了!!!
     * 这就是 Propagation.REQUIRED 最典型事务隔离级别的特性!!!
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping("/add4")
    public int add4(UserInfo userInfo) {
        // 非空效验(验证用户名和密码不为空)
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername()) || !StringUtils.hasLength(userInfo.getPassword())) {
            return 0;
        }

        // 添加用户
        int userResult = userService.add(userInfo);

        // 添加日志
        LogInfo logInfo = new LogInfo();
        logInfo.setName("日志名");
        logInfo.setDesc("日志说明: " + userResult);
        logService.add(logInfo);

        // 返回结果
        return userResult;
    }

    /**
     * add4方法 是 支持当前事务 的举例, 下面的 add5方法 是 不支持当前事务 的举例(会创建一个新的事务),
     * 因为会创建一个新的事务,
     * 所以, 本事务的事务隔离级别随意!
     *
     * 设置添加用户正常, 添加日志异常, 最后运行代码, 浏览器尝试添加操作:
     * 发现, 用户添加成功,
     * 但是, 日志没有添加成功!
     * 这就是 propagation = Propagation.REQUIRES_NEW 事务隔离级别的特性!!!
     *
     * @param userInfo
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @RequestMapping("/add5")
    public int add5(UserInfo userInfo) {
        // 非空效验(验证用户名和密码不为空)
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername()) || !StringUtils.hasLength(userInfo.getPassword())) {
            return 0;
        }

        // 添加用户
        int userResult = userService.add(userInfo);

        // 添加日志
        LogInfo logInfo = new LogInfo();
        logInfo.setName("日志名");
        logInfo.setDesc("日志说明: " + userResult);
        logService.add(logInfo);

        // 返回结果
        return userResult;
    }

    /**
     * 而当事务的隔离级别为 Propagation.NOT_SUPPORTED 的时候.
     *
     * 设置添加用户正常, 添加日志异常, 最后运行代码, 浏览器尝试添加操作:
     * 添加用户和添加日志都会出现在数据库中.
     *
     * 代码不在多余展示!
     */

    /**
     * 设置事务隔离级别: 嵌套事务!!!
     *
     * 设置添加用户正常, 添加日志异常, 最后运行代码, 浏览器尝试添加操作:
     *
     * 1. 当没有使用 try...catch...语句 手动回滚时,
     * 发生回滚的事务是全局的, 也就是说 添加用户方法 也被回滚了,
     * 最终执行结果是添加用户和添加日志都回滚了!!!
     *
     * 2. 当使用 try...catch...语句 手动回滚时,
     * 最终执行结果是添加用户没有回滚,
     * 但是, 添加日志回滚了!!!
     *
     * 这就是 propagation = Propagation.NESTED 嵌套事务隔离级别的特性!!!
     * @param userInfo
     * @return
     */
    @Transactional(propagation = Propagation.NESTED)
    @RequestMapping("/add6")
    public int add6(UserInfo userInfo) {
        // 非空效验(验证用户名和密码不为空)
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername()) || !StringUtils.hasLength(userInfo.getPassword())) {
            return 0;
        }

        // 添加用户
        int userResult = userService.add(userInfo);

        // 添加日志
        LogInfo logInfo = new LogInfo();
        logInfo.setName("XXX日志");
        logInfo.setDesc("XXX日志说明: " + userResult);
        logService.add(logInfo);

        // 返回结果
        return userResult;
    }
}
