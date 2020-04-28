package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.Permission;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/14 19:59
 * @Description
 */
@Repository
@Mapper
public interface PermissionMapper {
    List<Permission> seleceAllById(Integer id);
}
