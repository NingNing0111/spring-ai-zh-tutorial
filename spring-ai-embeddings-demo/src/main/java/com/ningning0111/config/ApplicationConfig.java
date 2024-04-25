package com.ningning0111.config;

import org.springframework.ai.document.DocumentTransformer;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Project: com.ningning0111.config
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/25 17:55
 * @Description:
 */
@Configuration
public class ApplicationConfig {

    // 文本分割器
    @Bean
    public DocumentTransformer documentTransformer() {
        return new TokenTextSplitter();
    }


}
