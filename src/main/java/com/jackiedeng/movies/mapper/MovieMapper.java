package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.Movie;
import com.jackiedeng.movies.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 00:26
 * @Description
 */
@Repository
public interface MovieMapper {
    List<Movie> findAll();

    int deleteByPrimaryKey(Integer id);

    int insert(Movie record);

    int insertSelective(Movie record);



    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);

    Movie selectByPrimaryKey(Integer id);

    int queryById(Integer id);

    List<Movie> queryAllByLimit(int offset, int limit);

    void update(Movie movie);

    boolean deleteById(Integer id);
}