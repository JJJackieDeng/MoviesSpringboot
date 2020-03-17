package com.jackiedeng.movies.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/7 22:21
 * @Description
 */
@ControllerAdvice
public class MyShiroException {
    /**
     * 处理Shiro权限拦截异常
     */
    @ResponseBody
    @ExceptionHandler(value = AuthenticationException.class)
    public Map<String, Object> defaultErrorHandler() {
        Map<String, Object> map = new HashMap<>(20);
        map.put("403", "权限不足，请联系管理员");
        return map;
    }
}
