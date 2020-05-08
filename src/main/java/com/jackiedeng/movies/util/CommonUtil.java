package com.jackiedeng.movies.util;

import com.jackiedeng.movies.pojo.Seat;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/9 12:11
 * @Description
 */
public class CommonUtil {
    /**
     * 返回info为 空对象 的成功消息的JSON
     */
    public static JSONObject successJson() {
        return successJson();
    }

    public static List<Seat> formatJson(String seatJson){
        Object parse = com.alibaba.fastjson.JSONObject.parse(seatJson);
        return  new ArrayList<>();
    }
 }
