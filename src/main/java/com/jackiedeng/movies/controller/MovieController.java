package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.Movie;
import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.result.ResultFactory;
import com.jackiedeng.movies.service.MovieService;
import javafx.util.BuilderFactory;
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
    /**
     * 分页查询查询全部电影*/
    @GetMapping("selectAll")
    public List<Movie> selectAll(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "20") Integer limit) {
        List<Movie> movie = movieService.queryAllByLimit(offset, limit);
        if (movie != null) {
            return movie;
        } else {
            System.out.println("无数据");
            return null;
        }
    }


}
