package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.Seat;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.result.ResultFactory;
import com.jackiedeng.movies.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/21 09:57
 * @Description
 */
@RestController
@RequestMapping("seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping(value="add",consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Result add(@RequestBody Seat seat) {
        boolean flag = seatService.insert(seat);
        if (flag) {
            return ResultFactory.bulidSuccessResult(seatService.queryById(seat.getId()));
        }
        return ResultFactory.bulidFailResult("添加失败");
    }

    @GetMapping("/selectAll")
    public List<Seat> queryAll(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "20") Integer limit) {
        List<Seat> seats = seatService.queryAllByLimit(offset, limit);
        if (seats != null) {
            return seats;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Result updateSeats(@RequestBody Seat seat){
        boolean flag = seatService.update(seat);
        if (flag){
            return ResultFactory.buildResult(200,"修改成功",seatService.queryById(seat.getId()));
        }
        return ResultFactory.buildResult(400,"修改失败",null);
    }

    @DeleteMapping("delete")
    public Result deleteSeats(Integer id){
        if (id != null){
            seatService.deleteById(id);
            return ResultFactory.buildResult(200,"删除成功",null);
        }
        return ResultFactory.buildResult(400,"删除失败",null);
    }
}
