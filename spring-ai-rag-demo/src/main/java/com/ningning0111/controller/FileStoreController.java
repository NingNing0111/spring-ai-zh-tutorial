package com.ningning0111.controller;

import com.ningning0111.service.FileStoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Project: com.ningning0111.controller
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/25 18:52
 * @Description:
 */
@RequestMapping("/file")
@RestController
public class FileStoreController {
    private final FileStoreService fileStoreService;

    public FileStoreController(FileStoreService fileStoreService) {
        this.fileStoreService = fileStoreService;
    }

    @PostMapping("/upload")
    public Object uploadFile(MultipartFile file){
        return fileStoreService.saveFile(file);
    }
}
