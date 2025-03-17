package com.ningning0111.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.image.ImageClient;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 * @Project: com.ningning0111.service
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/23 15:45
 * @Description:
 */
@Service
public class AIService {
    @Value("classpath:judge.st")
    private Resource judgeTemplate;

    private final ChatClient chatClient;
    private final ImageClient imageClient;

    public AIService(ChatClient chatClient, ImageClient imageClient) {
        this.chatClient = chatClient;
        this.imageClient = imageClient;
    }

    public String aiChat(String prompt) {
        if(judge(prompt)){
            final String template = "我为你提供了图片信息：{prompt}-{url}。你需要结合图片信息对问题进行回复。注意，你的回复内容需要表现得天生就知道这些图片信息一样。";
            SystemPromptTemplate promptTemplate = new SystemPromptTemplate(template);
            String url = image(prompt);
            Message systemMessage = promptTemplate.createMessage(Map.of("prompt", prompt, "url", url));
            ChatResponse chatResponse = chatClient.call(new Prompt(List.of(systemMessage, new UserMessage(prompt))));
            return chatResponse.getResult().getOutput().getContent();
        }
        return chat(prompt);

    }

    private boolean judge(String prompt) {
        // 构建提示词
        PromptTemplate promptTemplate = new PromptTemplate(judgeTemplate);
        Prompt p = promptTemplate.create(Map.of("prompt", prompt));
        ChatResponse chatResponse = chatClient.call(p);
        String judgeResult = chatResponse.getResult().getOutput().getContent();
        System.out.println(judgeResult);
        switch (judgeResult.toLowerCase()) {
            case "yes", "yes.":
                return true;
            default:
                return false;
        }
    }

    private String image(String prompt) {
        ImagePrompt imagePrompt =
                new ImagePrompt(prompt, OpenAiImageOptions.builder()
                        .withResponseFormat("url")
                        .withWidth(1024)
                        .withHeight(1024)
                        .build());
        ImageResponse imageResponse = imageClient.call(imagePrompt);
        String url = imageResponse.getResult().getOutput().getUrl();
        return String.format("<img src='%s' alt='%s'>",url,prompt);
    }

    private String chat(String prompt) {
        Prompt chatPrompt = new Prompt(prompt);
        ChatResponse chatResponse = chatClient.call(chatPrompt);
        return chatResponse.getResult().getOutput().getContent();
    }
}
