package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.Cinema;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.result.ResultFactory;
import com.jackiedeng.movies.service.CinemaService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public Cinema selectOne(Integer id) {
        return this.cinemaService.queryById(id);
    }

    @GetMapping("selectAll")
    public List<Cinema> selectAll(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "20") Integer limit) {
        return this.cinemaService.queryAllByLimit(offset, limit);
    }
    /**
     * 根据影院名称模糊查询影院*/
    @GetMapping("selectByName")
    public List<Cinema> selectByName(@Param("cinemaName") String cinemaName) {
        return this.cinemaService.queryByName(cinemaName);
    }

    /**
     * 根据影院名称模糊查询影院*/
    @GetMapping("selectByAddress")
    public List<Cinema> selectByAddress(@Param("address") String address) {
        return this.cinemaService.queryByAddress(address);
    }

    @PostMapping("add")
    @ResponseBody
    public Result addCinema(@RequestBody Cinema cinema){
        cinema.setCreateTime(new Date());
        boolean flag = cinemaService.insert(cinema);
        if (flag){
            return ResultFactory.buildResult(200,"添加成功",cinemaService.queryById(cinema.getId()));
        }
        return ResultFactory.bulidFailResult("添加失败，请重试或联系管理员");
    }

    @PostMapping("update")
    @ResponseBody
    public Result updateCinema(@RequestBody Cinema cinema){
        boolean flag = cinemaService.update(cinema);
        if (flag){
            return ResultFactory.buildResult(200,"修改成功",cinemaService.queryById(cinema.getId()));
        }
        return ResultFactory.buildResult(400,"修改失败",null);
    }

    @PostMapping("deleteById")
    public Result deleteCinema(Integer id){
        if (id != null){
            cinemaService.deleteById(id);
            return ResultFactory.buildResult(200,"删除成功",null);
        }
        return ResultFactory.buildResult(400,"删除失败",null);
    }
}
