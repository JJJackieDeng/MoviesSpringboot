package com.jackiedeng.movies.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/25 18:05
 * @Description
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index.html");
    }

    @RequestMapping("/index")
    public ModelAndView indexPath(){
        return new ModelAndView("index.html");
    }

}
