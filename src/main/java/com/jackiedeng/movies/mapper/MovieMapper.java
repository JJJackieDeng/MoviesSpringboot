package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.Movie;
import com.jackiedeng.movies.pojo.Order;
import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 00:26
 * @Description
 */
public interface MovieMapper {
    List<Movie> findAll();
}
