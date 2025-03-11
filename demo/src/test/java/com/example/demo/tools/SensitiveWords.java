package com.example.demo.tools;

import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lichengxiang
 * Date: 2025-03-11
 * Time: 16:47
 */
@SpringBootTest
public class SensitiveWords {
    @Autowired
    private SensitiveWordBs sensitiveWordBs;

    @Test
    public void sensitive() {
        final String text = "五星红旗迎风飘扬，毛主席的画像屹立在天安门前。";

        List<String> wordList = sensitiveWordBs.findAll(text);
        System.out.println(wordList.toString());
    }
}
