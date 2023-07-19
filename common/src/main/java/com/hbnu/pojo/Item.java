package com.hbnu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : [LuanHao]
 * @createTime : [25/4/2023 上午 10:41]
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_item")
public class Item extends BasePojo{

    @TableId("id")
    private Long id;
    private String title;
    private String sellPoint;
    private Long price;
    private Integer num;
    private String barcode;
    private String image;
    private Integer cid;
    private Integer status;
}
