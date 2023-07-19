package com.hbnu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : [LuanHao]
 * @createTime : [9/6/2023 上午 11:46]
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_content")
public class Content extends BasePojo{

    @TableId
    private Long id;
    private Long categoryId;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
