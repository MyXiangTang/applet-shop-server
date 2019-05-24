package com.bishe.appletshopserver.controller;

import com.bishe.appletshopserver.model.response.ReTurnT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author TomBing_Tang
 * @Description 文件上传
 * @Date 2019/5/23 18:11
 * @Modify
 */
@RestController
@RequestMapping("/file")
public class FileController {

    Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ReTurnT<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
        LOGGER.info("===============================upload=====================");
        if (file.isEmpty()) {
            LOGGER.info("文件为空空");
            return ReTurnT.FAIL;
        }
        // 文件名
        String fileName = file.getOriginalFilename();
        LOGGER.info(fileName);
        // 后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 上传后的路径
        String filePath = "/data/pic/";
        // 新文件名
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(new File(filePath + fileName).getAbsolutePath());
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
        return new ReTurnT<>(ReTurnT.SUCCESS_CODE, fileName);
    }

    @GetMapping("/delete")
    public ReTurnT<String> uploadFile(String name) {
        return ReTurnT.SUCCESS;
    }
}