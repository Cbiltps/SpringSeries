package com.example.mybatis.mapper;

import com.example.mybatis.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-05-16
 * Time: 17:49
 */
@Mapper
public interface ArticleMapper {
    // 根据文章 id 获取文章
    public ArticleInfo getArticleById(@Param("id") Integer id);
}
