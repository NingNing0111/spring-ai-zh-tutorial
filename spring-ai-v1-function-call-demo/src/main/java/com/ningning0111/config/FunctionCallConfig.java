package com.ningning0111.config;

import com.ningning0111.function.CurrentTimeFun;
import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.ai.model.function.FunctionCallbackWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

/**
 * @Project: com.ningning0111.config
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/7/19 12:51
 * @Description: 函数配置类，用于配置Spring AI涉及到的所有函数Bean
 */
@Configuration
public class FunctionCallConfig {
//    @Bean
//    @Description("获取指定位置的当前时间") // 函数描述，向AI描述这个函数是干嘛的
//
//    public Function<CurrentTimeFun.Request,CurrentTimeFun.Response> currentTimeFun() {
//        return new CurrentTimeFun();
//
//    }

    @Bean
    public FunctionCallback currentTimeFun() {
        return FunctionCallbackWrapper.builder(new CurrentTimeFun())
                .withName("currentTime") // (1) 函数名称
                .withDescription("Get the current time in location") // (2) 函数描述
                .build();
    }
}
