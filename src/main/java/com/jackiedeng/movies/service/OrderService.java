package com.jackiedeng.movies.service;

import com.jackiedeng.movies.pojo.Order;
import org.omg.CORBA.ORB;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/11 23:47
 * @Description
 */
public interface OrderService {

    /**
     * 查询订单数成交量最多的前六条数据*/
    List<Order> queryHots();

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    Order queryById(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    Order queryByOrderId(String orderId);

    /**
    * 根据用户ID查询订单
    *  */
    List<Order> queryByUser(String user);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Order> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    boolean insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    boolean update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);



}
