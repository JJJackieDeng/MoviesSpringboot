package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/6 23:10
 * @Description
 */
@Repository
public interface UserMapper {
//    查询所有
//        @Select("select * from users")
        List<User> findAll();
}
