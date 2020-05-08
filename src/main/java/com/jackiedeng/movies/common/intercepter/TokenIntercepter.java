package com.jackiedeng.movies.common.intercepter;

import com.alibaba.fastjson.JSONObject;
import com.jackiedeng.movies.common.enums.ApiResponseEnum;
import com.jackiedeng.movies.common.util.ApiResponseUtil;
import com.jackiedeng.movies.common.util.JwtUtil;
import com.jackiedeng.movies.pojo.ApiResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/5 21:04
 * @Description 自定义token拦截器 (JWT)
 */
public class TokenIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token =request.getHeader("access_token");

        /*token 不存在*/
        if( null != token){
//            验证token是否正确
            boolean result = JwtUtil.verify(token);
            if (result) {
                return true;
            }
        }
        ApiResponse apiResponse = ApiResponseUtil.getApiResponse(ApiResponseEnum.AUTH_ERROR);
        responseMessage(response,response.getWriter(),apiResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 返回信息至前端
     */

    private void responseMessage(HttpServletResponse response, PrintWriter out,ApiResponse apiResponse){
        response.setContentType("application/json; charset=utf-8");
        out.print(JSONObject.toJSONString(apiResponse));
//        刷新
        out.flush();
        out.close();
    }
}
