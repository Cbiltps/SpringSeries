package com.example.demo.controller;

import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lichengxiang
 * Date: 2024-12-20
 * Time: 20:39
 */
@RestController
public class TestController {

    @Autowired
    private SensitiveWordBs sensitiveWordBs;

    @RequestMapping("/message")
    public void addSensitiveWords(@RequestParam String sendmessage) {
        // 1. 模拟数据
        final String text = "aa, bb, cc的五星红旗迎风飘扬, 毛主席的画像屹立在天安门前. ";
        // 2. 添加敏感词
        sensitiveWordBs.addWord(sendmessage);
        // 3. 查找数据中的敏感词
        List<String> wordList = sensitiveWordBs.findAll(text);
        System.out.println(wordList.toString());
        // 4. 替换敏感词
        String replaceStr = sensitiveWordBs.replace(text);
        System.out.println(replaceStr);
    }
}
