package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/11 23:47
 * @Description
 */
@Repository
@Mapper
public interface OrderMapper {


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
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Order> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orders 实例对象
     * @return 对象列表
     */
    List<Order> queryAll(Order orders);

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    boolean insert(Order orders);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 影响行数
     */
    boolean update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
}
