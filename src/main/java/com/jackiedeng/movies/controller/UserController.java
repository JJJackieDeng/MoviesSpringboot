package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.service.UserService;
import com.jackiedeng.movies.service.serviceImpl.UserServiceImpl;
import com.jackiedeng.movies.util.CommonUtil;
import io.swagger.models.Model;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class UserController {
    @Autowired
    private UserService userService;

//    @ResponseBody
//    @RequestMapping("/test2")
//    public User test2(){
//        User user = new User();
//        user.setId(12);
//        user.setPassword("12");
//        user.setUsername("phpfzh-test2");
//        return user;
//    }


    @RequestMapping("/userLists")
    public List<User> showUsers() {
        List<User> list = userService.findAll();
        return list;
    }

//    @GetMapping("/list")
//    public JSONObject listUser(HttpServletRequest request) {
//        return userService.listUser(CommonUtil.request2Json(request));
//    }


    @RequestMapping("showUser")
    public String showUser(Model model){
        List<User> list =userService.findAll();

//        model.addAttribute("user",list.get(0));
        return "redirect:index";
    }
}
