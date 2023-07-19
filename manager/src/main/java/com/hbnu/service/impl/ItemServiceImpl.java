package com.hbnu.service.impl;

import com.hbnu.dao.*;
import com.hbnu.pojo.Item;
import com.hbnu.pojo.ItemDesc;
import com.hbnu.pojo.ItemParam;
import com.hbnu.service.ItemService;
import com.hbnu.vo.EasyUITable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 5:29]
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;
    @Autowired
    private ItemParamMapper itemParamMapper;
    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public EasyUITable findItemByPage(Integer page, Integer rows) {
//        1、获取商品的记录总数
        int total = itemMapper.selectCount(null);

        /*
        * 2、获取分页后的数据
        * sql:select * from tb_item limit 起始页下标, 查询条数
        * */
        int start = (page - 1) * rows;
        List<Item> itemList = itemMapper.findItemByPage(start, rows);

        /*
        * EasyUITable table = new EasyUITable();
        * table.setTotal(total);
        * table.setRows(itemList);
        * */
        return new EasyUITable(total, itemList);
    }

    @Override
    @Transactional
    public void saveItem(Item item, ItemDesc itemDesc) {
        item.setStatus(1).setCreated(new Date()).setUpdated(item.getCreated());

        itemMapper.insert(item);

        itemDesc.setItemId(item.getId()).setCreated(item.getCreated()).setUpdated(item.getCreated());
        itemDescMapper.insert(itemDesc);
    }

    @Override
    public void updateItem(Item item) {
        item.setCreated(new Date());
        itemMapper.updateById(item);
    }

    @Override
    public void deleteItems(Long[] ids) {
        List<Long> idList = Arrays.asList(ids);
        itemMapper.deleteBatchIds(idList);
    }

    @Override
    public void updateItemState(int status, Long[] ids) {
        for (Long id : ids) {
            Item item = new Item();
            item.setId(id).setStatus(status).setUpdated(new Date());
            itemMapper.updateById(item);
        }
    }

    @Override
    public ItemDesc findItemDescById(Long itemId) {
        return itemDescMapper.selectById(itemId);
    }

    @Override
    public EasyUITable findParamByPage(Integer page, Integer rows) {
        int total = itemParamMapper.selectCount(null);

        int start = (page - 1) * rows;
        List<ItemParam> itemParamList = itemParamMapper.findItemParamByPage(start, rows);

        for (ItemParam itemParam : itemParamList) {
            itemParam.setItemCatName(itemCatMapper.selectById(itemParam.getItemCatId()).getName());
        }

        return new EasyUITable(total, itemParamList);
    }
}
