package com.ningning0111.service;

import com.ningning0111.entity.KeyInfo;
import com.ningning0111.repository.KeyInfoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.StreamingChatClient;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @Project: com.ningning0111.service
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/22 17:36
 * @Description:
 */
@RequiredArgsConstructor
@Service
public class ChatService {
    private final KeyInfoRepository repository;

    // 初始化一些key 这些key应该是可调用的
    @PostConstruct
    public void initData() {
        KeyInfo keyInfo = new KeyInfo();
        keyInfo.setKey("sk-KgvugzpKzki15GFxB72e7782De844b23B3E4Fc6dDf40B29a");
        keyInfo.setApi("https://api.mnzdna.xyz");
        keyInfo.setDescription("Key分享自：https://pgthinker.me/2023/10/03/196/");
        repository.save(keyInfo);
    }

    // 阻塞式
    public ChatClient getChatClient() {
        OpenAiApi openAiApi = randomGetApi();
        assert openAiApi != null;
        return new OpenAiChatClient(openAiApi);
    }

    // 流式
    public StreamingChatClient getStreamChatClient() {
        OpenAiApi openAiApi = randomGetApi();
        assert openAiApi != null;
        return new OpenAiChatClient(openAiApi);
    }

    // 随机获取一个OpenAiApi
    private OpenAiApi randomGetApi(){
        List<KeyInfo> keyInfoList = repository.findAll();
        // 如果数据库中没有KeyInfo对象，则返回null
        if (keyInfoList.isEmpty()) {
            return null;
        }
        // 随机选择一个KeyInfo对象
        Random random = new Random();
        KeyInfo randomKeyInfo = keyInfoList.get(random.nextInt(keyInfoList.size()));
        return new OpenAiApi(randomKeyInfo.getApi(),randomKeyInfo.getKey());
    }
}
