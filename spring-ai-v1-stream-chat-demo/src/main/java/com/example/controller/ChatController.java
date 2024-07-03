package com.example.controller;

import com.example.model.dto.GetChatDto;
import com.example.model.dto.PostChatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Map;

/**
 * @Project: com.example.controller
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/7/3 09:08
 * @Description: 出现 Broken pipe异常时 请参考issue：https://github.com/vaadin/framework/issues/11332
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin // 解决跨域
public class ChatController {
    private final ChatModel chatModel;
    @Value("classpath:author-book.st")
    private Resource resource;

    @PostMapping("/post-chat")
    public Flux<ChatResponse> postStreamChat(@RequestBody PostChatDto dto){
        PromptTemplate promptTemplate = new PromptTemplate(resource);
        Prompt prompt = promptTemplate.create(Map.of("author", dto.getAuthor()));
        return chatModel.stream(prompt).flatMapSequential(Flux::just);
    }

    @GetMapping("/get-chat")
    public Flux<ChatResponse> getStreamChat(GetChatDto dto){
        System.out.println(dto);
        PromptTemplate promptTemplate = new PromptTemplate(resource);
        Prompt prompt = promptTemplate.create(Map.of("author", dto.getAuthor()));
        return chatModel.stream(prompt).flatMapSequential(Flux::just);
    }

    @GetMapping("/test")
    public String test() {
        return "ok";
    }

}
