package com.jackiedeng.movies.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/4/6 21:01
 * @Description 支付宝沙箱环境配置类
 * 为保证沙箱长期稳定，每周日中午12点至每周一中午12点沙箱环境进行维护，期间可能出现不可用，敬请谅解。
 */
public class AlipayConfig {
     /**
      * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号*/
    public static String app_id = "2016102400751131";

     /**
      * 商户私钥，您的PKCS8格式RSA2私钥*/
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCL1l16dwGJLe4TdfmIZ7O1Ea/Lvm3cJ5ebV8mfKO7Q8AF4tmeVzsCQXYeA9ecqkFE8ExykXFGVZwx2motz5GaVTupeRL8npzQlOXoL1js7n6VpSKfAP810+XOK1UlhJyPyMJPVCoxtpCA2OOlsKSZAD3HDKm9o0hFI+Qbm7Qsp8BAFKFZ4BTPMHRlU1nVgRIZmizjqdoK/RA8pQU9/AfRsGndXbJ1v6CRd9y/ZH27KTbLlqtA1B/GjpDq33JelKtOQfCGXJker9WJp1fvq7SZpn1HxhJNk9iBpq5r7h93XXrazcLYWObJjgHvgO3G1MZJQCsaUVpK16/dbrmh6MgFLAgMBAAECggEAc4PfsJzCXgndE6JvQek4oKk9qXdj1Wu3Z5H7ckkkDuFUtd0ocK5ckGVS3ItGLPkOwiufi37fviVkPE2qSVAyFcEdBkaQCjercdyrH0AXqkdVI0XrnXqXRLwUYGmUtnbY0OakGGcgXioomeIloT3U5TJc7bYOVm7B7KAavYSvpjH1MZyxY9mzJsw/gWfey1A0uoyGyZ4rUglj8dsx82tr5kbpNmiE5FpUOsQRSGUMbtYQHxoqoc+5EhaxtmGCEnRwYE9VOS1hBpPYwi8HOomfU4NRZELMegtaVhcD/8ZXy0j1VqTotw238F8jGAFh6UTK7HSBXNdWXPFpc+mmFoo3MQKBgQDkqJ2dTPHlnwcGf+Ot8Vx4sEoCOryi6ii06vxFfnXMR4CT20NGmsEG/Da+UlThOASdtickklX6f6d/EAc8iFc68nXLozjoI0/hvf+tnVvRN6lIYNfV8H1uTfqA5jvoEFsEp3qhD43JTnN/Z2MG5+vsTQMnDf9tY+qf+AanSwdHpQKBgQCcjt/OVzK1V/WFInHMnDiexipbwidithL0Wo0V9nWh+TdzKemZp2R9b0Ff8XVsf++aQ24ZfeUk6jREbn9W6epYte8oeF/CJ6OCoPZUw69+KKvDyoPJUeV2ZbeeGBXDIp+1t9GBGE6vX49Pfg3Z9cPTuPtR7jwyOm3hjeoxNvVSLwKBgCifWBkJAXSU0w+xisZtOctrLkrFGpwq036IvLav58eZ8FrUOliBx8cw6ZzYTaIRbKiEIuIZaVLueNhXBaIYar7bMlgyMDr1gwyMz66NZTF/HQDxy4aDihUdn2JlBMGOnkzuYBfbBop7+ILq4Cnq6/v4FpZKo1VQye8PhkcUSj/NAoGAR6HPoTegify+57WE4BuyhGMjSmyhXLb2ITu1RhFIbV38EwNgUN+YSRQ4k0+FbKl01d54Z82EpMlMNOth9EB+6ywDSz8YgVtlowVG8C3BBDZTsPfeKKUCGpQb2YgnnOsgrCJ5B1o51mAg0Dxa1hlvClafFzOr80dss0EdoHsG8B0CgYBTJCe1YixHvNT1ViOt/ChTT8+TjqUGHD2nZXs5ptkLvsJqy+NjIt5x503M/H0cxD2rlEhFU1naRqxl5qLHi1vktgzXVZdvOgObbfpzH9tjzUNhB7FlVM/hiCYtBj/WozA9tg7x7DMH4/9HkFBeVfgz0TpPDJY4VLJpuKaF3lCtAw==";

    /**
     *  对应APPID下的支付宝公钥。*/
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt/bNfKRvfZDuQwHkU+MeyCoAPCS76fxCjms685BG9U8rmGUoWsqDAC9WMaSTjQnL0uD3hW2gWOKOJ1hxNDvfxqtkMsfGhotNpvbpiBxzoZYsqQ4fwsvfmpzm5QTECREnWmFn5rsatcgGUVwLkcNvCuL8uUtv1yVm3auV2JsQIPvXDisGRqOu6Hpwqoxygoi6agpZWDxPr3Z7Mg/UTQOyEL+/wFnthGOqm/oe0LFGKu4pTfOfnLfPCT5/xUNfL/if5hHw2p+QMhl5xdQ3/C1Vf0yBGUx3rxZZlqIvDKxmJbMhZkixWxer/byOlTOWfEDaRHzxV6KXZgdG4GCEeaPdhQIDAQAB";

    /*异步逻辑处理*/
    public static String notify_url = "http://localhost:8081/api/order/update";


    /**
     * 支付成功后跳转至前台用户个人中心的订单页面*/
    public static String return_url = "http://localhost:8080/personal/myOrders";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

     /**
      * 支付宝网关,默认不作更改*/
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";

    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord
     *  要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
