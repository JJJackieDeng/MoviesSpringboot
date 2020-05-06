package com.jackiedeng.movies.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/7 22:30
 * @Description shiro加密工具
 */
public class SHA256Util {
    /**
     * 私有构造器
     */
    private SHA256Util() {
    }

    /**
     * 加密算法
     */
    public final static String HASH_ALGORITHM_NAME = "SHA-256";

    /**
     * 循环次数
     **/
    public final static int HASH_ITERATIONS = 15;

    /**
     * 执行加密-采用SHA256和盐值加密
     **/
    public static String sha256(String password, String salt) {
        return new SimpleHash(HASH_ALGORITHM_NAME, password, salt, HASH_ITERATIONS).toString();
    }

}
