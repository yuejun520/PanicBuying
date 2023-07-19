package com.hbnu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : [LuanHao]
 * @createTime : [9/6/2023 上午 11:20]
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_content_category")
public class ContentCategory extends BasePojo{

    @TableId(type = IdType.AUTO)
    private long id;
    private long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Boolean isParent;
}
