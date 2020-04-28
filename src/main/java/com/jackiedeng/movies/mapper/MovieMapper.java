package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.Movie;
import com.jackiedeng.movies.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 00:26
 * @Description
 */
@Repository
@Mapper
public interface MovieMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Movie record);

    int insertSelective(Movie record);



    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);

    Movie selectByPrimaryKey(Integer id);

    Movie queryById(Integer id);

    List<Movie> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    void update(Movie movie);

    boolean deleteById(Integer id);
}
