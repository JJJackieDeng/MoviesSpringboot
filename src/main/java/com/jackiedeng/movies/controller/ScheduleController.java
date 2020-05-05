package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.common.util.ApiResponseUtil;
import com.jackiedeng.movies.pojo.ApiResponse;
import com.jackiedeng.movies.pojo.Schedule;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.result.ResultFactory;
import com.jackiedeng.movies.service.ScheduleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/17 23:47
 * @Description
 */
@RestController
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    /**
     * 查询单个
     */
    @GetMapping("/selectOne/{id}")
    public Schedule selectOne(@PathVariable Integer id) {
        return this.scheduleService.queryById(id);
    }

    /**
     * 根据ID修改信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ApiResponse updateOne(@RequestBody Schedule schedule) {
        boolean flag = scheduleService.update(schedule);
        if (flag) {
            return ApiResponseUtil.getApiResponse(scheduleService.queryById(schedule.getId()));
        } else {
            return ApiResponseUtil.getApiResponse(404, "更新失败");
        }

    }


    /**
     * 分页查询查询全部场次信息
     */
    @GetMapping("selectAll")
    public List<Schedule> selectAll(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "20") Integer limit) {
        List<Schedule> schedules = scheduleService.queryAllByLimit(offset, limit);
        if (schedules != null) {
            return schedules;
        } else {
            return null;
        }
    }

    /**
     * 根据日期查询电影场次
     */
    @GetMapping("queryByDate")
    public Result selectAllByDate(@Param(value = "dateStr") String dateStr, @Param(value = "movie_id") Integer movie_id, @Param(value = "cinema_id") Integer cinema_id) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateStr);
        List<Schedule> schedules = scheduleService.queryByDate(date, movie_id, cinema_id);
        if (schedules != null) {
            return ResultFactory.buildResult(200, "成功", schedules);
        } else {
            return ResultFactory.buildResult(400, "失败", null);
        }
    }

    /**
     * 根据ID删除单个schedule
     */
    @PostMapping("deleteById")
    public Result deleteById(@RequestParam Integer id) {
        boolean flag = scheduleService.deleteById(id);
        if (flag) {
            //删除之后查询所有用户并返回
            return ResultFactory.bulidSuccessResult(scheduleService.queryAllByLimit(0, 100));
        } else {
            return ResultFactory.bulidFailResult("删除失败");
        }
    }

    /**
     * 新增场次信息
     */
    @PostMapping(value = "add", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Result add(@RequestBody Schedule schedule) {

        boolean flag = scheduleService.insert(schedule);
        if (flag) {
            return ResultFactory.buildResult(200, "添加成功", this.scheduleService.queryById(schedule.getId()));
        } else {
            return ResultFactory.bulidFailResult("添加失败");
        }

    }

}
