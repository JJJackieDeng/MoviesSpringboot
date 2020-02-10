package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.User;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/6 23:10
 * @Description
 */
@Mapper
public interface UserMapper {
//    查询所有
        List<User> findAll();
}
