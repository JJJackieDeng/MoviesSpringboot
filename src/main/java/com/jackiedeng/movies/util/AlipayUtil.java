package com.jackiedeng.movies.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jackiedeng.movies.config.AlipayConfig;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/4/8 11:25
 * @Description
 */
public class AlipayUtil {
    public static String pay(String out_trade_no, String total_amount, String subject, String body) {
//获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
//设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

//设置订单信息
        AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
        //必填,商户订单号
        model.setOutTradeNo(out_trade_no);
        //必填,订单名称
        model.setSubject(subject);
        //必填,付款金额
        model.setTotalAmount(total_amount);
        //选填,商品描述
        model.setBody(body);
        //必填,电脑支付FAST_INSTANT_TRADE_PAY,手机支付QUICK_WAP_WAY
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
//model.setTimeoutExpress(timeout_express);//选填,增加自定义超时时间参数timeout_express
        alipayRequest.setBizModel(model);

//请求
        try {
        //把支付信息加密好(私钥),向支付宝后端申请支付,后端用公钥解开信息,生成带有二维码的连接返回给用户,要求用户按链接跳转
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            return result;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return "支付成功";
    }
}
