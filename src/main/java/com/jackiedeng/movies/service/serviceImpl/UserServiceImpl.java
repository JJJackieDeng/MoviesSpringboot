package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/6 23:26
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public  List<User> findAll(){
        return findAll();
    }
 }
