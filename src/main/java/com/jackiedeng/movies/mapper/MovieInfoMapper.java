package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.MovieInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 09:28
 * @Description
 */
@Repository
public interface MovieInfoMapper {
    List<MovieInfo> findAll();
}
