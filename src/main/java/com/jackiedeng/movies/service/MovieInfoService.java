package com.jackiedeng.movies.service;

import com.jackiedeng.movies.pojo.MovieInfo;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 09:29
 * @Description
 */
public interface MovieInfoService {
    List<MovieInfo> findAll();
}
