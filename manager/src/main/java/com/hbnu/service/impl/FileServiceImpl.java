package com.hbnu.service.impl;

import com.hbnu.service.FileService;
import com.hbnu.vo.ImageVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 8:01]
 */

@Service
@PropertySource("classpath:/properties/image.properties")
public class FileServiceImpl implements FileService {

    @Value("${image.localDirPath}")
    private String localDirPath;

    @Value("${image.urlDirPath}")
    private String urlDirPath;

    @Override
    public boolean saveFile(MultipartFile fileImage) {
        boolean flag = false;

        try {
            //1、获取图片名称
            String fileName = fileImage.getOriginalFilename();

            //2、创建文件对象，指定上传目录
            String dirpath = getPath();
            File dir = new File(dirpath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String path = dirpath + "\\" + fileName;
            File file = new File(path);

            //3、利用工具API执行输出操作
            fileImage.transferTo(file);
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        }

        return flag;
    }

    @Override
    public ImageVO upload(MultipartFile uploadFile) {
        String fileName = uploadFile.getOriginalFilename();
        fileName = fileName.toLowerCase();
        if (!fileName.matches("^.+\\.(jpg|png|gif)$")) {
            return ImageVO.fail();
        }

        try {
            BufferedImage bImage = ImageIO.read(uploadFile.getInputStream());
            int width = bImage.getWidth();
            int height = bImage.getHeight();

            if (width == 0 || height == 0) {
                return ImageVO.fail();
            }

            String dateDir = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            String dirFilePath = getPath() + "//" + dateDir;
            File dirFile = new File(dirFilePath);

            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }

            String uuid = UUID.randomUUID().toString();
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            String realFileName = uuid + fileType;
            String realFilePath = dirFilePath + realFileName;

            uploadFile.transferTo(new File(realFilePath));
            String url = urlDirPath + dateDir + realFileName;

            return new ImageVO(0, url, width, height);
        } catch (IOException e) {
            e.printStackTrace();
            return ImageVO.fail();
        }
    }

    private String getPath() {
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        return applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath() + "\\src\\main\\resources\\images";
    }
}
