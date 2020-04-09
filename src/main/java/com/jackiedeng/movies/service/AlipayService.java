package com.jackiedeng.movies.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/4/6 21:36
 * @Description
 */
public interface AlipayService {
    /**
     * 支付宝支付调用接口
     * @param response
     * @param request
     * @throws IOException
     */
    void  aliPay(HttpServletResponse response, HttpServletRequest request) throws IOException;

}
