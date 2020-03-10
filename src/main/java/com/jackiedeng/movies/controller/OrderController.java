package com.jackiedeng.movies.controller;

import com.jackiedeng.movies.pojo.Order;
import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.result.ResultFactory;
import com.jackiedeng.movies.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.RunnableScheduledFuture;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/11 23:47
 * @Description
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 通过主键查询单条数据
     *
     * @param主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Order selectOne(Integer id) {
        return this.orderService.queryById(id);
    }

    /**
     * 查询全部*/
    @GetMapping("selectAll")
    public List<Order> selectAll(@RequestParam(defaultValue = "0") Integer offset,@RequestParam(defaultValue = "20") Integer limit){
        return orderService.queryAllByLimit(offset,limit);
    }
    /**
     * 修改订单*/
    @PostMapping("update")
    public Result updateOne(@RequestBody Order requestOrder) {
        boolean flag = orderService.update(requestOrder);
        if (flag) {
            return ResultFactory.bulidSuccessResult(requestOrder);
        } else {
            return ResultFactory.bulidFailResult("添加失败");
        }

    }
    /**
     * 新增订单*/
    @PostMapping("add")
    public Result addOrder(Order order){
        boolean flag= orderService.insert(order);
        order.setOrderId(getOrderIdByUUID());
        if (flag){
            /*新增成功的时候*/
            return ResultFactory.buildResult(200,"添加成功",this.orderService.queryById(order.getId()));
        }else{
            return ResultFactory.bulidFailResult("添加失败");
        }

    }
    /**
     * 生成唯一的订单号
     * */
    public static String getOrderIdByUUID(){
//        int machineId = 1;//最大支持1-9个集群机器部署
        Date date = new Date();
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        //有可能是负数
        if(hashCodeV < 0) {
            hashCodeV = - hashCodeV;
        }

    //         0 代表前面补充0
//         4 代表长度为4
//         d 代表参数为正数型
        return  Integer.toString(hashCodeV);
    }

}
