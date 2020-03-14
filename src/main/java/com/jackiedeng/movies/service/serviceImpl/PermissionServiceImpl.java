package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.mapper.PermissionMapper;
import com.jackiedeng.movies.pojo.Permission;
import com.jackiedeng.movies.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/14 19:49
 * @Description
 */
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionService permissionService;
    @Override
    public List<Permission> seleceAllById(Integer id) {
        return permissionService.seleceAllById(id);
    }
}
