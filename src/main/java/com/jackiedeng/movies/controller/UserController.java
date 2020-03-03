package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.result.ResultFactory;
import com.jackiedeng.movies.service.UserService;
import com.jackiedeng.movies.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;
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

    /**
     * 查询单个
     */
    @GetMapping("/selectOne/{id}")
    public User selectOne(@PathVariable Integer id) {
        return this.userService.queryById(id);
    }

    /**
     * 根据ID更新
     */
    @PostMapping("/update")
    public Result updateOne(@RequestBody User requestUser) {
        boolean flag = userService.update(requestUser);
        if (flag) {
            return ResultFactory.bulidSuccessResult(requestUser);
        } else {
            return ResultFactory.bulidFailResult("添加失败");
        }

    }

    /**
     * 登录接口
     */
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

    /**
     * 分页查询查询全部用户
     */
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

    /**
     * 根据ID删除单个user
     */
    @DeleteMapping("deleteById")
    public Result deleteById(@RequestParam Integer id) {
        boolean flag = userService.deleteById(id);
        if (flag) {
            //删除之后查询所有用户并返回
            return ResultFactory.bulidSuccessResult(userService.queryAllByLimit(0, 100));
        } else {
            return ResultFactory.bulidFailResult("删除失败");
        }
    }

    @PostMapping("add")
    public Result addUser(User user) {

        /**
         *MD5加密*/
        /**
         * 第一次加密*/
        String firstPass = MD5Util.inputPassToFormPass(user.getPassword());
        /**
         * 第二次加密*/
        String secondPass = MD5Util.inputPassToDBPass(firstPass, "1a2b3c4d");
        user.setPassword(secondPass);
        boolean flag = userService.insert(user);
        if (flag) {
            /**
             * 新增成功的时候,并返回当前新增数据*/
            /*todo 在新建用户成功的时候设置当前时间为创建时间*/
/*//            Timestamp date=new Timestamp(System.currentTimeMillis());
//            user.setCreateTime(date);*/
            return ResultFactory.buildResult(200, "添加成功", this.userService.queryById(user.getId()));
        } else {
            return ResultFactory.bulidFailResult("添加失败");
        }

    }

}

