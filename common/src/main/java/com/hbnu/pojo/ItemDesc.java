package com.hbnu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 7:02]
 */

@Data
@Accessors(chain = true)
@TableName("tb_item_desc")
public class ItemDesc extends BasePojo {

    @TableId
    private Long itemId;
    private String itemDesc;
}
