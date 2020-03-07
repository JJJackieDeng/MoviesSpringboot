package com.jackiedeng.movies.pojo;

import com.jackiedeng.movies.common.enums.ApiResponseEnum;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/5 21:23
 * @Description 返回给web的信息
 */
public class ApiResponse {
    private int errCode = 0;

    private String errMsg;

    private Object data;

    public ApiResponse(){

    }


    public ApiResponse(Object data) {
        this.data = data;
    }

    public ApiResponse(ApiResponseEnum apiResponseEnum){
        this.errCode = apiResponseEnum.getErrCode();
        this.errMsg = apiResponseEnum.getErrMsg();
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
