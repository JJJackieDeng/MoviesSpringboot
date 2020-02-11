package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.Order;
import com.jackiedeng.movies.service.OrderService;
import com.jackiedeng.movies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/11 23:47
 * @Description
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("orderLists")
    public List<Order> showOrders(){
        List<Order> list = orderService.findAll();
        return list;
    }
}
