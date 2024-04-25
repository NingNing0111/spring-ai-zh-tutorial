package com.ningning0111;

import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.document.DocumentTransformer;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Project: com.ningning0111
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/25 18:07
 * @Description:
 */
@SpringBootTest
public class VectorStoreTest {
    @Autowired
    private DocumentTransformer tokenTextSplitter;
    @Autowired
    private VectorStore vectorStore;

    @Value("classpath:CV.pdf")
    private Resource resource;


    @Test
    public void addDocumentToVectorDB() {
        TikaDocumentReader tikaDocumentReader = new TikaDocumentReader(resource);
        List<Document> fileDocuments = tikaDocumentReader.get();
        List<Document> documents = tokenTextSplitter.apply(fileDocuments);
        vectorStore.accept(documents);
    }

    @Test
    public void similaritySearch() {
        List<Document> documents = vectorStore.similaritySearch("竞赛经历");
        // 获取每个Document里的content
        List<String> collect = documents.stream().map(Document::getContent).toList();
        collect.forEach(e->{
            System.out.println("-------");
            System.out.println(e);
        });
    }
}
