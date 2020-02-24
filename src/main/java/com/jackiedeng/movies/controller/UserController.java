package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.result.ResultFactory;
import com.jackiedeng.movies.service.UserService;
import com.sun.javafx.scene.web.Debugger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/selectOne/{id}")
    public User selectOne(@PathVariable Integer id) {
        return this.userService.queryById(id);
    }

    @PostMapping("/update")
    public Result updateOne(@RequestBody User requestUser) {
        boolean flag = userService.update(requestUser);
        if (flag) {
            return ResultFactory.bulidSuccessResult(requestUser);
        } else {
            return ResultFactory.bulidFailResult("添加失败");
        }

    }

    @ResponseBody
    @PostMapping("dologin")
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

    @GetMapping("selectAll")
    public List<User> selectAll(@RequestParam Integer offset, @RequestParam Integer limit) {
        List<User> user = userService.queryAllByLimit(offset, limit);
        if (user != null) {
            return user;
        } else {
            System.out.println("无数据");
            return null;
        }
    }


}

