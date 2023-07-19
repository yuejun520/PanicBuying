package com.hbnu.controller;

import com.hbnu.service.FileService;
import com.hbnu.vo.ImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 7:26]
 */

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/file")
    public String file(MultipartFile fileImage){
        if (fileService.saveFile(fileImage)) {
            return "文件上传成功!!!";
        } else {
            return "文件上传失败!!!";
        }
    }

    @RequestMapping("/pic/upload")
    public ImageVO fileUpload(MultipartFile uploadFile) {
        return fileService.upload(uploadFile);
    }
}
