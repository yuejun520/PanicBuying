package com.hbnu.controller;

import com.hbnu.pojo.Item;
import com.hbnu.pojo.ItemDesc;
import com.hbnu.service.ItemService;
import com.hbnu.vo.EasyUITable;
import com.hbnu.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 5:44]
 */

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/query")
    public EasyUITable findItemByPage(Integer page, Integer rows) {
        return itemService.findItemByPage(page, rows);
    }

    /*
    * 业务需求：
    * url: http://localhost:8080/item/save
    * 参数: id=1&title=112312
    * 返回值: sysResult 200 201
    * */
    @RequestMapping("/save")
    public SysResult saveItem(Item item, ItemDesc itemDesc) {
        try {
            itemService.saveItem(item, itemDesc);
            return SysResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return SysResult.fail();
        }
    }

    /*
    * 实现商品修改
    * 规则：一般都需要通过主键进行修改
    * */
    @RequestMapping("/update")
    public SysResult updateItem(Item item) {
        itemService.updateItem(item);
        return SysResult.success();
    }

    /*
    * 商品删除
    * url:/item/detele
    * 参数: ids: id,id,id
    * 返回值: SysResult
    * */
    @RequestMapping("/delete")
    public SysResult deleteItem(Long[] ids) {
        itemService.deleteItems(ids);
        return SysResult.success();
    }

    /*
    * 下架
    * url: /item/instock
    * */
    @RequestMapping("/instock")
    public SysResult instock(Long[] ids) {
        int status = 2;
        itemService.updateItemState(status, ids);
        return SysResult.success();
    }

    /*
    * 上架
    * url: /item/reshelf
    * */
    @RequestMapping("/reshelf")
    public SysResult reshelf(Long[] ids) {
        int status = 1;
        itemService.updateItemState(status, ids);
        return SysResult.success();
    }

    /*
    * 实现商品详情查询
    * {status=200, msg=, data:{itemDesc的JSON数据}}
    * */
    @RequestMapping("/query/item/desc/{itemId}")
    public SysResult findItemDescById(@PathVariable Long itemId) {
        ItemDesc itemDesc = itemService.findItemDescById(itemId);
        //将数据回传给页面
        return SysResult.success(itemDesc);
    }

    @RequestMapping("/param/list")
    public EasyUITable findParamByPage(Integer page, Integer rows) {
        return itemService.findParamByPage(page, rows);
    }
}
