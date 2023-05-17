package com.example.mybatis.mapper;

import com.example.mybatis.model.ArticleInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-05-16
 * Time: 18:19
 */
@SpringBootTest
@Slf4j
class ArticleMapperTest {

    @Resource
    private ArticleMapper articleMapper;

    @Test
    void getArticleById() {
        ArticleInfo articleInfo = articleMapper.getArticleById(1);
        log.info("文章详情: " + articleInfo);
    }
}