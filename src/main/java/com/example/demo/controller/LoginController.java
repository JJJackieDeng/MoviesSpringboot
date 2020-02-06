package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/1/6 14:45
 * @Description
 */
@RestController
public class LoginController {

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        //对<html>进行转义，以防XSS攻击
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
        if(!Objects.equals("admin",username)||!Objects.equals("123456",requestUser.getPassword())){
            String message  = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        }else{
            return new Result(200);
        }
    }
}
