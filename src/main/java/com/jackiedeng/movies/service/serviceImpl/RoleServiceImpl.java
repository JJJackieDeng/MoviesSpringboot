package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.pojo.Role;
import com.jackiedeng.movies.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/14 17:51
 * @Description
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleService roleService;

    @Override
    public List<Role> selectAllById(Integer id) {
        return roleService.selectAllById(id);
    }
}
