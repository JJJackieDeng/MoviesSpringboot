package com.jackiedeng.movies.pojo;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/4/25 23:36
 * @Description
 */
public class SmsResponseData {
    /**
     * 阿里短信响应封装类
     */
    private String Message;
    private String RequestId;
    private String BizId;
    private String Code;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    public String getBizId() {
        return BizId;
    }

    public void setBizId(String bizId) {
        BizId = bizId;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
