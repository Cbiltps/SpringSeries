package com.example.demo.config;

import com.github.houbb.sensitive.word.api.IWordAllow;
import com.github.houbb.sensitive.word.api.IWordDeny;
import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import com.github.houbb.sensitive.word.support.allow.WordAllows;
import com.github.houbb.sensitive.word.support.deny.WordDenys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lichengxiang
 * Date: 2025-03-11
 * Time: 17:32
 */
@Configuration
public class SensitiveWordConfig {

    @Autowired
    private MyWordDeny myWordDeny;

    /**
     * 初始化引导类
     * @return 初始化引导类
     * @since 1.0.0
     */
    @Bean
    public SensitiveWordBs wordBs() {
        IWordDeny wordDeny = WordDenys.chains(WordDenys.defaults(), myWordDeny);
        IWordAllow wordAllow = WordAllows.chains(WordAllows.defaults());

        SensitiveWordBs sensitiveWordBs = SensitiveWordBs.newInstance()
                .wordDeny(wordDeny)
                .wordAllow(wordAllow)
                .init();

        return sensitiveWordBs;
    }
}
