package com.ningning0111.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.document.DocumentTransformer;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Project: com.ningning0111.service
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/25 18:41
 * @Description:
 */
@Service
public class FileStoreService {
    private final VectorStore vectorStore;
    private final DocumentTransformer documentTransformer;

    public FileStoreService(VectorStore vectorStore, DocumentTransformer documentTransformer) {
        this.vectorStore = vectorStore;
        this.documentTransformer = documentTransformer;
    }

    public Object saveFile(MultipartFile file){
        try {
            Resource resource = file.getResource();
            TikaDocumentReader tikaDocumentReader = new TikaDocumentReader(resource);
            List<Document> fileDocuments = tikaDocumentReader.get();
            List<Document> documents = documentTransformer.apply(fileDocuments);
            vectorStore.accept(documents);
            return "上传成功";
        }catch (Exception e){
            return e.getCause();
        }
    }
}
