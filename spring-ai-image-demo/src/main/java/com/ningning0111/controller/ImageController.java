package com.ningning0111.controller;

import com.ningning0111.service.AIService;
import org.springframework.ai.image.ImageClient;
import org.springframework.ai.image.ImageGeneration;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.ai.openai.api.OpenAiImageApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Project: com.ningning0111.controller
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/23 14:50
 * @Description:
 */
@RestController
public class ImageController {
    private final ImageClient imageClient;

    private final AIService aiService;

    public ImageController(ImageClient imageClient, AIService aiService) {
        this.imageClient = imageClient;
        this.aiService = aiService;
    }

    @GetMapping("/image")
    public String image(String prompt) {
        ImagePrompt imagePrompt =
                new ImagePrompt(prompt, OpenAiImageOptions.builder()
                        .withModel(OpenAiImageApi.ImageModel.DALL_E_3.getValue())
                        .withHeight(1024)
                        .withWidth(1024)
                        .withResponseFormat("url") // URL or b64_json
                        .build());
        ImageResponse imageResponse = imageClient.call(imagePrompt);
        List<ImageGeneration> results = imageResponse.getResults();
        // 图片url
        String url = results.get(0).getOutput().getUrl();
        return String.format("<img src='%s' alt='%s'>",url,prompt);
    }

    @GetMapping("/chat")
    public String chat(String prompt) {
        return aiService.aiChat(prompt);
    }
}
