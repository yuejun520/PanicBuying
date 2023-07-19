package com.hbnu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 8:10]
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ImageVO {
    private Integer error = 0;
    private String url;
    private Integer width;
    private Integer height;

    public static ImageVO fail() {
        return new ImageVO(1, null, null, null);
    }
}
