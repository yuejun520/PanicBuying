package com.hbnu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 4:48]
 */

@SpringBootApplication
@MapperScan("com.hbnu.dao")
public class ManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
}
