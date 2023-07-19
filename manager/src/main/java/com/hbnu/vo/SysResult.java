package com.hbnu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 6:27]
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysResult {
    private Integer state;
    private String msg;
    private Object data;

    public static SysResult success() {
        return new SysResult(200, null, null);
    }

    public static SysResult success(Object object) {
        return new SysResult(200, null, object);
    }

    public static SysResult success(String msg, Object object) {
        return new SysResult(200, msg, object);
    }

    public static SysResult fail() {
        return new SysResult(201, null, null);
    }

    public static SysResult fail(String msg) {
        return new SysResult(201, msg, null);
    }
}
