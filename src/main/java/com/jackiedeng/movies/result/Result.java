package com.jackiedeng.movies.result;

import java.io.Serializable;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/16 17:18
 * @Description
 */
public class Result implements Serializable {

    private static final long serialVersionUID = -4762928619495260423L;
    /**
     * 状态码*/
    private Integer code;
    /**
     * 描述*/
    private String message;
    /**
     * 返回数据*/
    private Object data;


    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
