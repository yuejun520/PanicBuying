package com.hbnu.service;

import com.hbnu.pojo.ItemCat;
import com.hbnu.vo.EasyUITree;

import java.util.List;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 5:55]
 */

public interface ItemCatService {
    ItemCat findItemCatById(Long itemCatId);

    List<EasyUITree> findEasyUITree(Long parentId);
}
