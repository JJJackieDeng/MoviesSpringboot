package com.jackiedeng.movies.common.util;

import com.jackiedeng.movies.common.enums.ApiResponseEnum;
import com.jackiedeng.movies.pojo.ApiResponse;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/5 21:19
 * @Description web统一返回工具类(JWT)
 */
public class ApiResponseUtil {

    /**
     * 获取请求成功响应的ApiResponse
     *
     * @param data
     * @return
     */
    public static ApiResponse getApiResponse(Object data) {
        return getApiResponse(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getMsg(),data);
    }

    /**
     * 获取其他请求响应的ApiResponse
     *
     * @param code
     * @param msg
     * @return
     */
    public static ApiResponse getApiResponse(int code, String msg) {
        return getApiResponse( code,msg, null);
    }

    /**
     * 枚举信息转统一返回对象
     *
     * @param apiResponseEnum
     * @return
     */
    public static ApiResponse getApiResponse(ApiResponseEnum apiResponseEnum) {
        return getApiResponse(apiResponseEnum.getCode(), apiResponseEnum.getMsg());
    }


    public static ApiResponse getApiResponse( int code,String msg, Object data) {
        ApiResponse apiResponse = new ApiResponse(data);
        apiResponse.setCode(code);
        apiResponse.setMsg(msg);
        return apiResponse;
    }

}
