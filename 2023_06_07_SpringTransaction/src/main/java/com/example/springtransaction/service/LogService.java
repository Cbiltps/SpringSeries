package com.example.springtransaction.service;

import com.example.springtransaction.mapper.LogMapper;
import com.example.springtransaction.model.LogInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-07-01
 * Time: 18:03
 */
@Service
public class LogService {

    @Resource
    private LogMapper logMapper;

    @Transactional(propagation = Propagation.NESTED)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.REQUIRED)
    public int add(LogInfo logInfo) {
        int result = logMapper.add(logInfo);
        System.out.println("添加日志结果: " + result);
//        try {
        int number = 10 / 0;
//        } catch (Exception e) {
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); // 设置手动回滚
//        }
        return result;
    }
}