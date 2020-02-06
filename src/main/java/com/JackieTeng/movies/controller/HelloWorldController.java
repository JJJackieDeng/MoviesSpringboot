package com.JackieTeng.movies.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index(){
        System.out.println("helloWorld");
        return "Springboot build success";
    }
}
