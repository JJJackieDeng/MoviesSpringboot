package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.mapper.OrderMapper;
import com.jackiedeng.movies.pojo.Order;
import com.jackiedeng.movies.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/11 23:48
 * @Description
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    /**
     * 查询订单数成交量最多的前六条数据
     */
    @Override
    public List<Order> queryHots() {
        return orderMapper.queryHots();
    }

    @Override
    public Order queryById(Integer id) {
        return this.orderMapper.queryById(id);
    }

    /**
     * 根据用户ID查询订单
     *
     * @param user
     */
    @Override
    public List<Order> queryByUser(String user) {
        return orderMapper.queryByUser(user);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param orderId@return 实例对象
     */
    @Override
    public Order queryByOrderId(String orderId) {
        return orderMapper.queryByOrderId(orderId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Order> queryAllByLimit(int offset, int limit) {
        List<Order> orders = this.orderMapper.queryAllByLimit(offset, limit);
        if (orders != null) {
            return orders;
        } else {
            System.out.println("暂无订单！");
            return null;
        }
    }

    /**
     * 新增订单包括status,runTime,endTime,address,seats,invalid(订单有效时间)，total(总价)，cinemaID，movie_id
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Order order) {
        try {
            /*生成订单号*/
            order.setOrderId(getOrderIdByUUID());
            this.orderMapper.insert(order);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * todo 修改订单状态
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Order orders) {

        /* * 用户未付款之前取消订单，退款，*/
        String status=orders.getStatus();
        String oldOrder = ""+orderMapper.queryById(orders.getId()).getDate()+orderMapper.queryById(orders.getId()).getRunTime();
        DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        Date date=null;
        try {
            date = dataFormat.parse(oldOrder);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date.getTime()>date.getTime()) {

        }
        switch (status){
            case "未支付":
                /*如果已支付，*/
                System.out.println("");break;
            case "已支付":break;
            case "已完成":break;
            case "已取消":break;
            default:
                return false;
        }
        try {
            this.orderMapper.update(orders);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        try {
            this.orderMapper.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 生成唯一的订单号
     */
    public static String getOrderIdByUUID() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        String date=simpleDateFormat.format(new Date());
        int hashCodeV = +UUID.randomUUID().toString().hashCode();
        //有可能是负数
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        String orderId=date+hashCodeV;
        //         0 代表前面补充0
//         4 代表长度为4
//         d 代表参数为正数型
        return orderId;
    }

}
