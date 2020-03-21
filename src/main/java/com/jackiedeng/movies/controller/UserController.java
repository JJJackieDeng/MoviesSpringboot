package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.common.enums.ApiResponseEnum;
import com.jackiedeng.movies.common.util.ApiResponseUtil;
import com.jackiedeng.movies.common.util.JwtUtil;
import com.jackiedeng.movies.pojo.ApiResponse;
import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.result.ResultFactory;
import com.jackiedeng.movies.service.UserService;
import com.jackiedeng.movies.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
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

    @GetMapping("/selectByLikeName")
    public User selectByLikeName(@RequestParam String userName) {
        return this.userService.selectByLikeName(userName);
    }

    /**
     * 根据ID更新
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ApiResponse updateOne(@RequestBody User requestUser) {
        String pwd = MD5Util.inputPassToDBPass(requestUser.getPassword(), requestUser.getSalt());
        boolean flag = userService.update(requestUser);
        if (flag) {
            return ApiResponseUtil.getApiResponse(requestUser, 200, "更新成功");
        } else {
            return ApiResponseUtil.getApiResponse(404, "更新失败");
        }

    }

    /**
     * 登录接口
     */
    @ResponseBody
    @PostMapping("dologin")
    public ApiResponse login(@RequestParam String userName, @RequestParam String password, HttpSession session) {
        User user = userService.queryByName(userName);
        if (user != null) {
//            将前台表单填写的密码加盐二次加密
            String pwd = MD5Util.inputPassToDBPass(password, user.getSalt());
            if (pwd.equals(user.getPassword())) {
                String token = JwtUtil.sign(user.getUserName(), user.getId());
                if (token != null) {
                    session.setAttribute("user",user);
                    return ApiResponseUtil.getApiResponse(token);
                }
            } else {
                return ApiResponseUtil.getApiResponse(ApiResponseEnum.AUTH_ERROR);
            }
        }
        //返回登陆失败消息
        return ApiResponseUtil.getApiResponse(ApiResponseEnum.LOGIN_FAIL);
    }

    /**
     * 分页查询查询全部用户
     */
    @GetMapping("selectAll")
    public List<User> selectAll(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "20") Integer limit) {
        List<User> user = userService.queryAllByLimit(offset, limit);
        if (user != null) {
            return user;
        } else {
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

    /**
     *后台新增用户，前台为注册用户功能
     */
    @PostMapping(value="add",consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Result addUser(@RequestBody  User user){

        /*
         *MD5加密,前端注册用户时已对密码进行一次加密传输，这里只需要取JSON中的password后进行加盐加密即可
         */
        /*
         * 第一次加密*/
/*        String firstPass = MD5Util.inputPassToFormPass(user.getPassword());*/
        /*
         * 第二次加密*/
//        生成8位数的salt
        String salt = JwtUtil.getCharAndNum(8);
        String secondPass = MD5Util.inputPassToDBPass(user.getPassword(), salt);
        user.setPassword(secondPass);
        user.setCreateTime(new Date());
        user.setSalt(salt);
        boolean flag = userService.insert(user);
        if (flag) {
            /*
             * 新增成功的时候,并返回当前新增数据
             * */
            return ResultFactory.buildResult(200, "添加成功", this.userService.queryById(user.getId()));
        } else {
            return ResultFactory.bulidFailResult("添加失败");
        }

    }
    @PostMapping("/logout")
    @ResponseBody
    public Result logout(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return ResultFactory.bulidSuccessResult("请重新登录");
    }

}

