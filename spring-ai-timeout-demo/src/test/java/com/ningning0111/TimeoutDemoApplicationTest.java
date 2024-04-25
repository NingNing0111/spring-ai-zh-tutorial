package com.ningning0111;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Project: com.ningning0111
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/25 20:05
 * @Description:
 */
@SpringBootTest
public class TimeoutDemoApplicationTest {

    @Autowired
    private ChatClient chatClient;

    @Test
    public void chatTest(){
        String message = chatClient.call("你好");
        System.out.println(message);
    }
}
