package com.jackiedeng.movies.result;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/16 17:18
 * @Description
 */
public class Result<T> {

    /**
    *返回给前端的信息*/
    private String message;
    /**
     * 请求是否正常
     *
     */
    private boolean success;

    /**
     *返回的数据
     */
    private T detail;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }
}
