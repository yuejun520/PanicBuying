package com.hbnu.service;

import com.hbnu.vo.EasyUITable;
import com.hbnu.vo.EasyUITree;

import java.util.List;

/**
 * @author : [LuanHao]
 * @createTime : [9/6/2023 上午 11:24]
 */

public interface ContentService {
    List<EasyUITree> findEasyUITree(Long parentId);

    EasyUITable findContentByPage(Long categoryId, Integer page, Integer rows);
}
