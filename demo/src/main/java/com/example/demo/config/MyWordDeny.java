package com.example.demo.config;

import com.github.houbb.sensitive.word.api.IWordDeny;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lichengxiang
 * Date: 2025-03-11
 * Time: 17:38
 */
@Component
public class MyWordDeny implements IWordDeny {
    @Override
    public List<String> deny() {
        return Arrays.asList("aa", "bb");
    }
}
