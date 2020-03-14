package com.jackiedeng.movies.service;

import com.jackiedeng.movies.pojo.Role;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/14 17:44
 * @Description
 */
public interface RoleService {

    List<Role> selectAllById(Integer id);
}
