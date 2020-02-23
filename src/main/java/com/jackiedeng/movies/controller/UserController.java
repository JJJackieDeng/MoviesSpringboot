package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.service.UserService;
import com.jackiedeng.movies.service.serviceImpl.UserServiceImpl;
import com.jackiedeng.movies.util.CommonUtil;
import io.swagger.models.Model;
import org.apache.ibatis.annotations.Param;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/7 00:15
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("selectOne/{id}")
    public User selectOne(@PathVariable Integer id) {
        return this.userService.queryById(id);
    }

    @PostMapping("update/{id}")
    public User updateOne(@PathVariable Integer id) {
        return this.userService.update(id);
    }
//    @GetMapping("selectByName/{userName}")
//    public User selectByName(@PathVariable String userName){
//        return this.userService.queryByName(userName);
//
//
//    }

    @ResponseBody
    @RequestMapping("dologin")
    public User login(@RequestParam String userName, @RequestParam String password) {
        User user = userService.queryByName(userName, password);
//        JSONObject jsonObject = new JSONObject();
        if (user != null) {
                return user;
        } else {
            System.out.println("无数据");
           return null;
        }
//        return jsonObject.toString();
//        return this.userService.queryByName(userName, password);
    }
}

