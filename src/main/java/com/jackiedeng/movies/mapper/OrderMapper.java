package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/11 23:47
 * @Description
 */
@Repository
public interface OrderMapper {
    List<Order> findAll();
}
