package com.jackiedeng.movies.service;

import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.result.Result;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/6 23:25
 * @Description
 */
public interface UserService {
     /**
      * 通过ID查询单条数据
      *
      * @param id 主键
      * @return 实例对象
      */
     User queryById(Integer id);

     /**
      * 查询多条数据
      *
      * @param offset 查询起始位置
      * @param limit 查询条数
      * @return 对象列表
      */
     List<User> queryAllByLimit(int offset, int limit);

     /**
      * 新增数据
      *
      * @param user 实例对象
      * @return 实例对象
      */
     boolean insert(User user);

     /**
      * 修改数据
      *
      * @param user 实例对象
      * @return 实例对象
      */
     boolean update(User user);

     /**
      * 通过主键删除数据
      *
      * @param id 主键
      * @return 是否成功
      */
     boolean deleteById(User user);
     /**
      * 登录接口
      *
      * @param userName 登录专用接口
      * @return 是否成功
      */
     User queryByName(String userName,String password);

//     User selectByname(User user);
     /**
      * 用户登录
      * */
     Result login(User user);


}
