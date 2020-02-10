package com.jackiedeng.movies.service;

import com.jackiedeng.movies.pojo.User;
import org.json.JSONObject;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/6 23:25
 * @Description
 */
public interface UserService {

     List<User> findAll();

//    JSONObject listUser(JSONObject jsonObject);
}
