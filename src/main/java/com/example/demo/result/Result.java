package com.example.demo.result;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/1/6 14:43
 * @Description
 */
public class Result {
    //响应码
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
