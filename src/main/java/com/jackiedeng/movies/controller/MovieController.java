package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.Movie;
import com.jackiedeng.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 00:23
 * @Description
 */
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("movieLists")
    public List<Movie> showMovies(){
        return movieService.findAll();
    }

}
