package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.mapper.OrderMapper;
import com.jackiedeng.movies.pojo.Order;
import com.jackiedeng.movies.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Order queryById(Integer id) {
        return this.orderMapper.queryById(id);
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
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Order order) {
        try {
            this.orderMapper.insert(order);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Order orders) {
        try {
            this.orderMapper.update(orders);
        } catch (Exception e) {
            return false;
        }
//        return this.queryById(orders.getId());
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
        return this.orderMapper.deleteById(id) > 0;
    }
}
