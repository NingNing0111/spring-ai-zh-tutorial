package com.ningning0111.controller;

import com.ningning0111.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: com.ningning0111.controller
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/22 17:49
 * @Description:
 */
@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    @GetMapping("/demo")
    public String chatDemo(String prompt){
        ChatClient chatClient = chatService.getChatClient();
        String response = chatClient.call(prompt);
        return response;
    }
}
