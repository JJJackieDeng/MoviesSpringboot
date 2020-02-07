package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.service.userService;
import com.jackiedeng.movies.serviceImpl.userServiceImpl;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/7 00:15
 * @Description
 */
@RestController
public class userController {
    @Autowired
    private userServiceImpl userService;

    @RequestMapping("userLists")
    public List<User> showUsers() {
        List<User> list = userService.findAll();
        return list;
    }

    @RequestMapping("showUser")
    public String showUser(Model model){
        List<User> list =userService.findAll();

//        model.addAttribute("user",list.get(0));
        return "redirect:index";
    }
}
