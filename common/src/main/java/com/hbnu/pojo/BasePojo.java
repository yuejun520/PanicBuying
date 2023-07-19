package com.hbnu.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : [LuanHao]
 * @createTime : [25/4/2023 上午 10:19]
 */

@Data
@Accessors(chain = true)
public class BasePojo implements Serializable {


    private static final long serialVersionUID = 1536592393107777968L;
    private Date created;
    private Date updated;
}
