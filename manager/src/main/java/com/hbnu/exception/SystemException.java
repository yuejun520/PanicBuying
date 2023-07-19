package com.hbnu.exception;

import com.hbnu.vo.SysResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 6:38]
 */

@RestControllerAdvice
@Slf4j
public class SystemException {

    @ExceptionHandler(RuntimeException.class)
    public SysResult exception(Throwable throwable) {
        throwable.printStackTrace();
        log.info(throwable.getMessage());
        return SysResult.fail("调用失败!!!");
    }
}
