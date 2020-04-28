package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.Role;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/14 17:53
 * @Description
 */
@Repository
@Mapper
public interface RoleMapper {

    List<Role> selectAllById(Integer id);
}
