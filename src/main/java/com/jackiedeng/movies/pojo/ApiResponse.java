package com.jackiedeng.movies.pojo;

import com.jackiedeng.movies.common.enums.ApiResponseEnum;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/5 21:23
 * @Description 返回给web的信息
 */
public class ApiResponse {
    private int Code = 0;

    private String Msg;

    private Object data;

    public ApiResponse(){

    }


    public ApiResponse(Object data) {
        this.data = data;
    }

    public ApiResponse(ApiResponseEnum apiResponseEnum){
        this.Code = apiResponseEnum.getCode();
        this.Msg = apiResponseEnum.getMsg();
    }

    public int getErrCode() {
        return Code;
    }

    public void setErrCode(int errCode) {
        this.Code = errCode;
    }

    public String getErrMsg() {
        return Msg;
    }

    public void setErrMsg(String errMsg) {
        this.Msg = errMsg;
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
                "Code=" + Code +
                ", Msg='" + Msg + '\'' +
                ", data=" + data +
                '}';
    }
}
