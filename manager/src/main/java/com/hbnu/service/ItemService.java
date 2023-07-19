package com.hbnu.service;

import com.hbnu.pojo.Item;
import com.hbnu.pojo.ItemDesc;
import com.hbnu.vo.EasyUITable;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 5:29]
 */

public interface ItemService {
    EasyUITable findItemByPage(Integer page, Integer rows);

    void saveItem(Item item, ItemDesc itemDesc);

    void updateItem(Item item);

    void deleteItems(Long[] ids);

    void updateItemState(int status, Long[] ids);

    ItemDesc findItemDescById(Long itemId);

    EasyUITable findParamByPage(Integer page, Integer rows);
}
