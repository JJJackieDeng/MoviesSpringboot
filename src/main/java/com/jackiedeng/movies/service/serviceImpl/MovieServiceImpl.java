package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.MovieOrder;
import com.jackiedeng.movies.mapper.MovieMapper;
import com.jackiedeng.movies.mapper.OrderMapper;
import com.jackiedeng.movies.pojo.Movie;
import com.jackiedeng.movies.pojo.Order;
import com.jackiedeng.movies.service.MovieService;
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
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieMapper movieMapper;

    @Override
    public List<Movie> findAll(){
        return movieMapper.findAll();
    }
}
