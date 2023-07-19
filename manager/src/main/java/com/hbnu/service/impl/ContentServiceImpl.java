package com.hbnu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hbnu.dao.ContentCategoryMapper;
import com.hbnu.dao.ContentMapper;
import com.hbnu.pojo.Content;
import com.hbnu.pojo.ContentCategory;
import com.hbnu.service.ContentService;
import com.hbnu.vo.EasyUITable;
import com.hbnu.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : [LuanHao]
 * @createTime : [9/6/2023 上午 11:24]
 */

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentCategoryMapper contentCategoryMapper;
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public List<EasyUITree> findEasyUITree(Long parentId) {
        List<ContentCategory> contentCategoryList = findContentCategoryByParentId(parentId);
        List<EasyUITree> treeList = new ArrayList<EasyUITree>();

        for (ContentCategory contentCategory : contentCategoryList) {
            Long id = contentCategory.getId();
            String text = contentCategory.getName();

            String state = contentCategory.getIsParent() ? "closed" : "open";

            EasyUITree easyUITree = new EasyUITree(id, text, state);
            treeList.add(easyUITree);
        }

        return treeList;
    }

    @Override
    public EasyUITable findContentByPage(Long categoryId, Integer page, Integer rows) {
        int total = contentMapper.selectCount(null);

        int start = (page - 1) * rows;
        List<Content> contentList = contentMapper.findContentByPage(categoryId, start, rows);

        return new EasyUITable(total, contentList);
    }

    private List<ContentCategory> findContentCategoryByParentId(Long parentId) {
        QueryWrapper<ContentCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentId);
        return contentCategoryMapper.selectList(queryWrapper);
    }
}
