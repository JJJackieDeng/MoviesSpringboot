package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.Score;
import com.jackiedeng.movies.service.ScoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;



/**
 * (Score)表控制层
 *
 * @author makejava
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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Score selectOne(Integer id) {
        return this.scoreService.queryById(id);
    }

}