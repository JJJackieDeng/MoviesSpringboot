package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.Movie;
import com.jackiedeng.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 00:23
 * @Description
 */
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("selectOne")
    public Movie selectOne(@RequestParam int id){
        return this.movieService.queryById(id);

    }
    @GetMapping("selectAll")
    public List<Movie> selectAll(@RequestParam int offset,@RequestParam int limit){
        return movieService.queryAllByLimit(offset,limit);

    }


}
