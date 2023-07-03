package com.example.springtransaction.mapper;

import com.example.springtransaction.model.LogInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-07-01
 * Time: 18:02
 */
@Mapper
public interface LogMapper {
    /**
     * 传递对象的好处:
     *     以后给对象添加属性时直接修改实体类的字段即可, 不用大面积的改代码!
     *     具有一定的 可维护性/扩展性 !
     * @param logInfo
     * @return
     */
    int add(LogInfo logInfo);
}