package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.Movie;
import com.jackiedeng.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
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

    @GetMapping("lists")
    public List<Movie> showMovies(){
        List<Movie> list = movieService.findAll();
        return list;
    }
    @GetMapping("selectOne/{id}")
    public int selectOne(@PathVariable(value = "id") int id){

        return this.movieService.queryById(id);

    }


}
