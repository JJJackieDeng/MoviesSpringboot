package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.Cinema;
import com.jackiedeng.movies.pojo.MovieInfo;
import com.jackiedeng.movies.service.CinemaService;
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
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;
    @GetMapping("selectOne")
    public Cinema selectOne(String id) {
        return this.cinemaService.queryById(id);
    }
    @GetMapping("selectAll")
    public List<Cinema> selectAll(@RequestParam Integer offset,@RequestParam Integer limit){
        return this.cinemaService.queryAllByLimit(offset,limit);
    }

}
