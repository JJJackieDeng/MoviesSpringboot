package com.jackiedeng.movies.service;

import com.jackiedeng.movies.pojo.Permission;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/14 17:48
 * @Description
 */
public interface PermissionService {

    List<Permission> seleceAllById(Integer id);
}
