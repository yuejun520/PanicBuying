package com.hbnu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author : [LuanHao]
 * @createTime : [7/6/2023 下午 3:30]
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_item_param")
public class ItemParam extends BasePojo {

    @TableId
    private Long id;
    private Long ItemCatId;
    private String ItemCatName;
    private String paramData;
}
