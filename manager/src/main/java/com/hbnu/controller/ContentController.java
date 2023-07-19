package com.hbnu.controller;

import com.hbnu.service.ContentService;
import com.hbnu.vo.EasyUITable;
import com.hbnu.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : [LuanHao]
 * @createTime : [9/6/2023 上午 11:16]
 */

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/category/list")
    public List<EasyUITree> findCategoryByParentId(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        return contentService.findEasyUITree(parentId);
    }

    @RequestMapping("/query/list")
    public EasyUITable findContentByPage(Long categoryId, Integer page, Integer rows) {
        return contentService.findContentByPage(categoryId, page, rows);
    }
}
