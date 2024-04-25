package com.ningning0111;

import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.openai.OpenAiEmbeddingOptions;
import org.springframework.ai.vectorstore.PgVectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Project: com.ningning0111
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/25 08:39
 * @Description:
 */
@SpringBootTest
public class EmbeddingDemoApplicationTest {

    @Autowired
    private EmbeddingClient embeddingClient;

    @Test
    public void quickStart() {
        String vectorString = "I'm learning Spring AI";
        EmbeddingRequest embeddingRequest =
                new EmbeddingRequest(List.of(vectorString),
                        OpenAiEmbeddingOptions.builder()
                                .withEncodingFormat("float")
                                .withModel("text-embedding-ada-002")
                                .build());

        EmbeddingResponse response = embeddingClient.call(embeddingRequest);
        System.out.println(response.getResult().getOutput());
    }

}
