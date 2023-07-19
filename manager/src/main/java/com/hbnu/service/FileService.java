package com.hbnu.service;

import com.hbnu.vo.ImageVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 8:01]
 */

public interface FileService {
    boolean saveFile(MultipartFile fileService);

    ImageVO upload(MultipartFile uploadFile);
}
