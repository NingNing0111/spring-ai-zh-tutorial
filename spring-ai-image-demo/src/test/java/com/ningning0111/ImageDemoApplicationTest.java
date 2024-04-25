package com.ningning0111;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImageClient;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.model.ModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Project: com.ningning0111
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/23 21:39
 * @Description:
 */
@SpringBootTest
public class ImageDemoApplicationTest {

    @Autowired
    private ChatClient chatClient;

    @Autowired
    private ImageClient imageClient;

    @Test
    public void test1() {
        ModelResponse chatResponse = chatClient.call(new Prompt("hi"));
        System.out.println(chatResponse);
    }

    @Test
    public void test2() {
        ModelResponse imageResponse = imageClient.call(new ImagePrompt("a dog"));
        System.out.println(imageResponse);
    }
}
