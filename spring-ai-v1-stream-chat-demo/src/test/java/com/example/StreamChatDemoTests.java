package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.StreamingChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

/**
 * @Project: com.example
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/8/3 15:14
 * @Description:
 */
@SpringBootTest
public class StreamChatDemoTests {

    @Autowired
    private StreamingChatModel streamingChatModel;
    @Test
    public void test1() throws InterruptedException {
        Flux<String> streamResp = streamingChatModel.stream("介绍下四大名著");
        streamResp.subscribe(item -> {
            if(item.contains("\n")){
                System.out.println("换行符");
            }
        });
        Thread.sleep(20000L);

    }
}
