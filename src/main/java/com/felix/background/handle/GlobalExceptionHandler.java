package com.felix.background.handle;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.util.SaResult;
import com.felix.background.dto.common.ResponseData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author imac
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public SaResult handlerException(Exception e) {
        if (e instanceof NotLoginException) {
            Map<String,Object> data=new HashMap<>();
            ResponseData responseData = new ResponseData();
            data.put("code",401);
            data.put("message",e.getMessage());
            responseData.setData(data);
            return SaResult.data(responseData);
        }
        return SaResult.error(e.getMessage());    }
}