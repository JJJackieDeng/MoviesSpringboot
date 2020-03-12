package com.jackiedeng.movies.common.enums;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/5 21:26
 * @Description web返回信息枚举类（JWT）
 */
public enum  ApiResponseEnum {

    /**
     * API调用成功返回
     */
    SUCCESS(200,"请求成功"),
    FAIL(404,"请求失败"),
    LOGIN_FAIL(10001,"登陆失败"),
    AUTH_ERROR(10002,"认证失败");

    private int Code = 0;

    private String Msg;


    private ApiResponseEnum(int Code, String Msg) {
        this.Code = Code;
        this.Msg = Msg;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }
}
