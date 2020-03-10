package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.MovieInfo;
import com.jackiedeng.movies.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 09:27
 * @Description
 */
@RestController
@RequestMapping("/movieInfo")
public class MovieInfoController {
    @Autowired
    private MovieInfoService movieInfoService;
    @GetMapping("selectOne")
    public MovieInfo selectOne(String id) {
        return this.movieInfoService.queryById(id);
    }
    @GetMapping("selectAll")
    public List<MovieInfo> selectAll(@RequestParam(defaultValue = "0") Integer offset,@RequestParam(defaultValue = "20") Integer limit){
        return this.movieInfoService.queryAllByLimit(offset,limit);
    }

}
