package com.jackiedeng.movies.controller;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.jackiedeng.movies.common.util.ApiResponseUtil;
import com.jackiedeng.movies.common.util.RedisUtil;
import com.jackiedeng.movies.pojo.ApiResponse;
import com.jackiedeng.movies.pojo.SmsResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/5/7 22:41
 * @Description
 */
@RestController
@RequestMapping("/sendMsg")
public class SendMsgController {

    /**
     * 用户下单成功的短信通知
     * @param userName
     * @param orderId
     * @param cinemaName
     * @param address
     * @param seats
     * @param schedule
     * @param phone
     * @return
     */
    @PostMapping("sendOrderInfo")
    public ApiResponse sendSuccessMsg(String userName,
                                      String orderId,
                                      String movieName,
                                      String cinemaName,
                                      String address,
                                      String seats,
                                      String schedule,
                                      String phone){
        //发送短信
        DefaultProfile profile = DefaultProfile.getProfile("cn-guangzhou",
                "LTAI4FoQn6Grkv7sGwYJgU61", "JmtWI3bdOsHYhTl9hcYTsbEFzC8gjZ");

        IAcsClient client = new DefaultAcsClient(profile);

        // 只需要修改签名和模板名称
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        //API版本
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        // 签名名称
        request.putQueryParameter("SignName", "随心影院");
        //模板编码
        request.putQueryParameter("TemplateCode", "SMS_186598872");
        String jsonParam = "{\"userName\": " + userName +
                "userName\": " + userName+
                "orderId\": " + orderId+
                "movieName\": " + movieName+
                "cinemaName\": " + cinemaName+
                "address\": " + address+
                "schedule\": " + schedule+
                "seats\": " + seats+"}";
        // 需要传json格式，参数为模板编码 ${code} 的code
        request.putQueryParameter("TemplateParam", jsonParam);

        try {
            // 发送短信
            CommonResponse response = client.getCommonResponse(request);
            SmsResponseData smsResponseData = JSON.parseObject(response.getData(), SmsResponseData.class);
            // 发送成功
            if ("OK".equals(smsResponseData.getCode())) {
                return ApiResponseUtil.getApiResponse(200, "发送成功");
            } else if ("isv.BUSINESS_LIMIT_CONTROL".equals(smsResponseData.getCode())) {
                //发送失败返回10001以防与原生状态码重复
                return ApiResponseUtil.getApiResponse(10001, "短信发送频率超限");
            }
        } catch (ServerException e) {
            e.printStackTrace();
            return ApiResponseUtil.getApiResponse(501, "服务端错误，发送失败");
        } catch (ClientException e) {
            e.printStackTrace();
            return ApiResponseUtil.getApiResponse(502, "客户端错误，发送失败");
        }
        return ApiResponseUtil.getApiResponse(503, "未知错误！");
    }
}
