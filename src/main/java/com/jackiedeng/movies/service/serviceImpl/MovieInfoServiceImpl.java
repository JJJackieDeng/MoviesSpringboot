package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.mapper.MovieInfoMapper;
import com.jackiedeng.movies.pojo.MovieInfo;
import com.jackiedeng.movies.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 09:29
 * @Description
 */
@Service
public class MovieInfoServiceImpl implements MovieInfoService {
    @Autowired
    MovieInfoMapper movieInfoMapper;
    @Override
    public List<MovieInfo> findAll(){
        return movieInfoMapper.findAll();
    }
}
