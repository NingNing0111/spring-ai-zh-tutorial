package com.ningning0111.config;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public ChatClient chatClient() {
        RetryTemplate retryTemplate = new RetryTemplate();
        TimeoutRetryPolicy timeoutRetryPolicy = new TimeoutRetryPolicy();
        timeoutRetryPolicy.setTimeout(3000); // 设置超时时间
        retryTemplate.setRetryPolicy(timeoutRetryPolicy);
        return new OpenAiChatClient(
                new OpenAiApi(
                        "https://api.openai.com",
                        "你的Key"),
                OpenAiChatOptions.builder().withModel(OpenAiApi.DEFAULT_CHAT_MODEL).withTemperature(0.7f).build(),
                null,retryTemplate);
    }
}
