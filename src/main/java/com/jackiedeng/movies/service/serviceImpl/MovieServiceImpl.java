package com.jackiedeng.movies.service.serviceImpl;


import com.jackiedeng.movies.mapper.MovieMapper;

import com.jackiedeng.movies.pojo.Movie;

import com.jackiedeng.movies.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/11 23:48
 * @Description
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieMapper movieMapper;


    @Override
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public Movie queryById(Integer id) {
        return movieMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Movie> queryAllByLimit(int offset, int limit) {
        return this.movieMapper.queryAllByLimit(offset, limit);
    }

    @Override
    public int insert(int id) {
        return 0;
    }

    @Override
    public int update(int id) {
        return 0;
    }

    /**
     * 新增数据
     *
     * @param movie 实例对象
     * @return 实例对象
     */

    /**
     * 修改数据
     *
     * @param movie 实例对象
     * @return 实例对象
     */

    public Movie update(Movie movie) {
        this.movieMapper.update(movie);
        return this.queryById(movie.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.movieMapper.deleteById(id);
    }
}
