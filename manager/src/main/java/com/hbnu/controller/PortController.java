package com.hbnu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : [LuanHao]
 * @createTime : [15/7/2023 下午 6:50]
 */

@RestController
public class PortController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/port")
    public String getPort() {
        return "本次访问的服务器端口号为：" + port;
    }
}
