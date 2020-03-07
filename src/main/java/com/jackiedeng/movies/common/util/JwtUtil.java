package com.jackiedeng.movies.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/5 20:21
 * @Description JSON Web Token 工具类（JWT）
 */
public class JwtUtil {
    /**
     * 有效时间为 1 天
     */
    private static final long VALID_TIME = 1000 * 60 * 60 * 24;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "e10adc3949ba59abbe56e057f20f883e";

    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            JWTVerifier verifier = JWT.require(algorithm)
                    .build();

            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    /**
     * 获得token中的信息，无密码也可获取
     *
     * @return token中包含的用户名
     */
    public static String getUserName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得token中的信息，无密码也可获取
     *
     * @return token中包含的用户id
     */
    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名 ，签名有效时间与
     *
     * @param userName
     * @return 加密后的token
     * @VALID_TIME 相同
     */
    public static String sign(String userName, Integer userId) {
        try {
            /*过期时间*/
            Date date = new Date(System.currentTimeMillis() + VALID_TIME);
            /*私钥为@TOKEN_SECRET,加密算法为HMAC256*/
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            /*头部信息,初始容量为2*/
            Map<String, Object> header = new HashMap<>(2);

            header.put("typ", "JWT");
            header.put("alg", "HS256");
            /*使用当前登录的userName,userId信息，生成签名*/
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userName", userName)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (IllegalArgumentException e) {
            return null;
        } catch (JWTCreationException e) {
            return null;
        }

    }

    /**
     * 生成字母与数字组成的随机数*/
    public static String getCharAndNum(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            /**
             * 输出字母还是数字*/
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            /**
             *  字符串*/
            if ("char".equalsIgnoreCase(charOrNum)) {
                /*取得大写字母还是小写字母*/
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                /**
                 * 生成数字*/
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
