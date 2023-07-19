package com.hbnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 4:58]
 */

@Controller
public class IndexController {

    @RequestMapping("/page/{moduleName}")
    public String module(@PathVariable String moduleName) {
        return moduleName;
    }
}
