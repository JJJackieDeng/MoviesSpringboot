package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.MovieInfo;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.result.ResultFactory;
import com.jackiedeng.movies.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public MovieInfo selectOne(Integer id) {
        return this.movieInfoService.queryById(id);
    }
    @GetMapping("selectAll")
    public List<MovieInfo> selectAll(@RequestParam(defaultValue = "0") Integer offset,@RequestParam(defaultValue = "20") Integer limit){
        return this.movieInfoService.queryAllByLimit(offset,limit);
    }
    /**
     * 查询*/
    @GetMapping("queryOrderByScore")
    public List<MovieInfo> queryOrderByScore() {
        return this.movieInfoService.queryOrderByScore();
    }    /**
     * 根据电影名称查询影片*/
    @GetMapping("queryLikeName")
    public List<MovieInfo> queryAllByLikeName(String movieName) {
        return this.movieInfoService.queryAllByLikeName(movieName);
    }


    /**
     * 添加影片*/
    @PostMapping(value="add",consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Result add(@RequestBody MovieInfo movieInfo){
       boolean flag = this.movieInfoService.insert(movieInfo);
       if (flag){
           return ResultFactory.buildResult(200,"添加成功",this.movieInfoService.queryById(movieInfo.getId()));
       }
       return ResultFactory.bulidFailResult("添加失败");
    }

}
