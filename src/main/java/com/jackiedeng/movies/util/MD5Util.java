package com.jackiedeng.movies.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/3 08:30
 * @Description
 */
public class MD5Util {
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    /**
     * 第一次MD5
     */
    public static String inputPassToFormPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        System.out.println(str);
        return str;
    }

    /**
     * 第二次MD5*/
    public static String formPassToDBPass(String formPass,String salt){
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }
    /**两次MD5*/
    public static String inputPassToDBPass(String inputPass,String saltDB){
        String formPass = inputPassToFormPass(inputPass);
        String dbPass =formPassToDBPass(formPass,saltDB);
        return dbPass;
    }

    /**
     *根据电影场次id+行+列生成唯一的座位ID
     * */
    public static String generateSeatId(Integer scheduleID,Integer row){
        String seatsId= scheduleID.toString()+row.toString();
        return md5(seatsId);
    }
}
