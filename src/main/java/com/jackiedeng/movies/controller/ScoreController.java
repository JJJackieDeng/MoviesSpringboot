package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.MovieInfo;
import com.jackiedeng.movies.pojo.Score;
import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.result.ResultFactory;
import com.jackiedeng.movies.service.MovieInfoService;
import com.jackiedeng.movies.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * (Score)表控制层
 * @Description 由于评论的真实性，不提供修改接口，如果用户自己想修改自己的评论的话，这个后期再加
 * @author JACIEDENG
 * @since 2020-03-04 22:57:37
 */
@RestController
@RequestMapping("score")
public class ScoreController {
    /**
     * 服务对象
     */
    @Resource
    private ScoreService scoreService;

    @Resource
    private MovieInfoService movieInfoService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public List<Score> selectOne(Integer id) {
        return this.scoreService.queryById(id);
    }

    /**
     * 分页查询查询全部用户
     */
    @GetMapping("selectAll")
    public List<Score> selectAll(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "20") Integer limit) {
        List<Score> scores = scoreService.queryAllByLimit(offset, limit);
        if (scores != null) {
            return scores;
        } else {
            System.out.println("无数据");
            return null;
        }
    }

    @PostMapping("deleteById")
    public Result deleteById(@RequestParam Integer id) {
        boolean flag = scoreService.deleteById(id);
        if (flag) {
            //删除之后查询所有用户并返回
            return ResultFactory.bulidSuccessResult(scoreService.queryAllByLimit(0, 100));
        } else {
            return ResultFactory.bulidFailResult("删除失败");
        }
    }

    @PostMapping(value = "add",consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Result addScore(@RequestBody Score score){
        boolean flag = scoreService.insert(score);
        if(flag){
            /*
             *用户每次评分将分数统计平均数并存到movieInfo中
             * */
            Float avg= scoreService.queryAvgById(score.getMovie_id());
            MovieInfo movieInfo = new MovieInfo();
            movieInfo.setId(score.getMovie_id());
            movieInfo.setScore(avg);
            movieInfoService.update(movieInfo);
            return ResultFactory.buildResult(200,"评分成功",scoreService.queryById(score.getId()));
        }
        return ResultFactory.bulidFailResult("评分失败，请联系管理员");
    }
}