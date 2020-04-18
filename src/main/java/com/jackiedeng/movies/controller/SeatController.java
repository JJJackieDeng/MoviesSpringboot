package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.common.util.ApiResponseUtil;
import com.jackiedeng.movies.mapper.OrderMapper;
import com.jackiedeng.movies.pojo.ApiResponse;
import com.jackiedeng.movies.pojo.Order;
import com.jackiedeng.movies.pojo.Schedule;
import com.jackiedeng.movies.pojo.Seat;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.result.ResultFactory;
import com.jackiedeng.movies.service.OrderService;
import com.jackiedeng.movies.service.SeatService;
import com.jackiedeng.movies.service.serviceImpl.OrderServiceImpl;
import com.jackiedeng.movies.util.CommonUtil;
import com.jackiedeng.movies.util.MD5Util;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private OrderService orderService;

    /**
     * 批量增加座位
     */
    @PostMapping(value = "add")
    @ResponseBody
    public ApiResponse add(Integer scheduleId, String rows,Order order) {
        List<Seat> seatList = new ArrayList<>();
        Seat tempSeat;
        List<String> scheduleList = new ArrayList<>();
        String[] row = rows.split(",");
        String tempScheduleId;
        //批量插入座位
        for (String s : row) {
            tempSeat = new Seat();
            tempSeat.setSchedule_id(scheduleId);
            tempSeat.setRow(Integer.parseInt(s));
            //使用场次ID与座位ID生成唯一标识符seatid
            tempScheduleId = MD5Util.generateSeatId(scheduleId, Integer.parseInt(s));
            scheduleList.add(tempScheduleId);
            tempSeat.setSeatid(tempScheduleId);
            seatList.add(tempSeat);
        }
        List<Seat> list = new ArrayList<>();
        Integer count = seatService.toInsert(scheduleList);
        if (count == 0) {
            /*
             * 可以新增座位，生成订单
             */
            /*后端生成订单号*/
/*             前端传过来的address,status,runtime为schudule中的schedule,seats字段为rows
            order.setStatus();*/
            boolean flag = seatService.insertBatch(seatList);
            if (flag) {
                /*
                选座成功后生成订单，订单ID由orderImpl生成
                * */
/*                order.setOrderUser(""); 从当前session中的user中取出来userName
                order.setStatus(""); //状态由前端传过来
                order.setAddress(""); //地址根据cinemaID查出来，
                order.setMovie_id(); movie_id由seatid查出来，
                order.setCinemaID("");cinemaID由seatid查出来，
                *//*电影开场日期*//*
                order.setDate(""); schedule中的Date
                *//*订单有效时间*//*
                order.setInvalid("");//前端传过来
                /*电影结束时间: 开场时间+电影时长*/
//                Order order=new Order();
//                order.setRunTime(order.getRunTime());
//                order.setEndTime(order.get);
//                order.setTotal(total);
//                order.setSeats(rows);
//                order.setAddress(address);
//                order.setMovieName(movieName);
//                order.setDate(date);
                /*下单人*/
                order.setOrderUser("admin");
                //
                order.setStatus("未支付");
                orderService.insert(order);
                return ApiResponseUtil.getApiResponse(200,"选座成功",this.orderService.queryById(order.getId()));
            }
        }
        return ApiResponseUtil.getApiResponse(404, "座位已被选，请选择其他座位", null);
    }

    /**
     * 搜索全部座位信息
     */

    @GetMapping("/selectAll")
    public ApiResponse queryAll(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "20") Integer limit) {
        List<Seat> seats = seatService.queryAllByLimit(offset, limit);
        if (seats != null) {
            return ApiResponseUtil.getApiResponse(seats);
        } else {
            return ApiResponseUtil.getApiResponse(400, "失败");
        }
    }

    @GetMapping("selectByScheduleId")
    public ApiResponse queryByScheduleId(Integer scheduleId) {
        List<Seat> seats = seatService.queryById(scheduleId);
        if (seats != null) {
            return ApiResponseUtil.getApiResponse(seats);
        } else {
            return ApiResponseUtil.getApiResponse(400, "失败");
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ApiResponse updateSeats(@RequestBody Seat seat) {
        boolean flag = seatService.update(seat);
        if (flag) {
            return ApiResponseUtil.getApiResponse(seatService.queryById(seat.getId()));
        }
        return ApiResponseUtil.getApiResponse(400, "失败");
    }

    @PostMapping("delete")
    public ApiResponse deleteSeats(Integer id) {
        if (id != null) {
            seatService.deleteById(id);
            return ApiResponseUtil.getApiResponse(seatService.queryById(null));
        }
        return ApiResponseUtil.getApiResponse(400, "失败");
    }
}
