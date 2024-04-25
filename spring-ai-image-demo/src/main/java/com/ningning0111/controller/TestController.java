package com.ningning0111.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImageClient;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.model.ModelResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: com.ningning0111.controller
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/23 21:14
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private final ChatClient chatClient;
    private final ImageClient imageClient;

    public TestController(ChatClient chatClient, ImageClient imageClient) {
        this.chatClient = chatClient;
        this.imageClient = imageClient;
    }

    @GetMapping("/chat")
    public ModelResponse chat() {
        ChatResponse chatResponse = chatClient.call(new Prompt("hi"));
        System.out.println(chatResponse);
        return chatResponse;
    }

    @GetMapping("/image")
    public ModelResponse image() {
        ImageResponse imageResponse = imageClient.call(new ImagePrompt("dog"));
        System.out.println(imageResponse);
        return imageResponse;
    }
}
