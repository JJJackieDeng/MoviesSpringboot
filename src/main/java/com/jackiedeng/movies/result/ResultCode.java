package com.jackiedeng.movies.result;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/24 21:57
 * @Description
 */
public enum ResultCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);


    public Integer code;

    ResultCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
