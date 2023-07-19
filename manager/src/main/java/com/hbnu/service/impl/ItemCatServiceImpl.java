package com.hbnu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hbnu.dao.ItemCatMapper;
import com.hbnu.pojo.ItemCat;
import com.hbnu.service.ItemCatService;
import com.hbnu.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 5:56]
 */

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public ItemCat findItemCatById(Long itemCatId) {
        return itemCatMapper.selectById(itemCatId);
    }

    /*
    * VO对象~~~转换~~~POJO
    * 思路：
    *   1、根据parentId查询一级商品分类信息 List<ItemCat>
    *   2、遍历List<ItemCat>~~~itemCat(DB)~~~Id/name~~~EasyUITree
    *   3、EasyUITree~~~封装到List集合中返回
    *
    * 原则：一个方法只完成一个任务
    * */
    @Override
    public List<EasyUITree> findEasyUITree(Long parentId) {
        List<ItemCat> itemCatList = findItemCatByParentId(parentId);
        List<EasyUITree> treeList = new ArrayList<EasyUITree>();

        for (ItemCat itemCat : itemCatList) {
            Long id = itemCat.getId();
            String text = itemCat.getName();
            //如果是父级closed 否则open
            String state = itemCat.getIsParent() ? "closed" : "open";

            EasyUITree easyUITree = new EasyUITree(id, text, state);
            treeList.add(easyUITree);
        }

        return treeList;
    }

    private List<ItemCat> findItemCatByParentId(Long parentId) {
        QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentId);
        return itemCatMapper.selectList(queryWrapper);
    }
}
