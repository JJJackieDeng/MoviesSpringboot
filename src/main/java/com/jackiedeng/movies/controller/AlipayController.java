package com.jackiedeng.movies.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.jackiedeng.movies.config.AlipayConfig;
import com.jackiedeng.movies.util.AlipayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/4/6 21:55
 * @Description
 */
@RestController
@RequestMapping("pay")
public class AlipayController {

    final static Logger log = LoggerFactory.getLogger(AlipayController.class);

    @PostMapping("/doPay")
    public String doPay(String orderID, String total, String movieName, String discription) throws Exception {
        /*订单号*/
//        String out_trade_no = orderID;
        String out_trade_no = "11564654616156";
        String total_amount = "78";
        /*订单名称*/
        String subject = "我和我的祖国";
        /*商品描述*/
        String body = "";
        return JSON.toJSONString(AlipayUtil.pay(out_trade_no, total_amount, subject, body));

    }

    /**
     * 异步通知处理
     */
    @PostMapping("/pay_notify")
    public void notifyUrl(HttpServletResponse response, HttpServletRequest request) throws IOException, AlipayApiException {
        PrintWriter out = response.getWriter();
        /*
         * 解决乱码问题
         * */
        request.setCharacterEncoding("utf-8");
        /**
         * 获取支付宝POST过来的反馈信息
         */
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String str : requestParams.keySet()) {
            String name = str;
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        /*
         * 调用SDK验证签名
         * */
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        if (!signVerified) {
            System.out.println("验签失败");
            out.print("fail");
            return;
        }
        //商户订单号,之前生成的带用户ID的订单号
        //支付宝交易号
        String out_trade_no = params.get("out_trade_no");
        String trade_no = params.get("trade_no");
        //付款金额
        String total_amount = params.get("total_amount");
        //交易状态
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

        if (trade_status.equals("TRADE_FINISHED")) {
            /*此处可自由发挥*/
            /*判断该笔订单是否在商户网站中已经做过处理
            如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
            如果有做过处理，不执行商户的业务程序
            注意：
            退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知*/
        } else if (trade_status.equals("TRADE_SUCCESS")) {
            /*判断该笔订单是否在商户网站中已经做过处理
            如果没有做过处理，根据订单号（out_trade_no在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
            如果有做过处理
            增加用户在数据库余额*/
            String[] ss = out_trade_no.split("_");
            int mid = Integer.parseInt(ss[1]);
            System.out.println("trade_no:" + trade_no + "<br/>out_trade_no:" + out_trade_no + "<br/>total_amount:" + total_amount);
        }
        out.print("success");
    }

    /**
     * 同步通知
     */
    @GetMapping("/pay_return")
    public String returnUrl(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
        System.out.println("同步通知");
        //解决乱码
        request.setCharacterEncoding("utf-8");
        /*
         * 获取支付宝GET过来的反馈信息
         */
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String str : requestParams.keySet()) {
            String name = str;
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        if (signVerified) {
            System.out.println("验签成功-跳转到成功后页面");
            //跳转至支付成功后的页面,
            return "redirect:payment";
        } else {
            System.out.println("验签失败-跳转到充值页面让用户重新充值");
            return "redirect:addmoney";
        }

    }
}
