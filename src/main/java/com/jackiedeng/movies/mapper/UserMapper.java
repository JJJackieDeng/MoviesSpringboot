package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.User;
import org.apache.ibatis.annotations.Param;
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
        /**
         * 通过ID查询单条数据
         *
         * @param id 主键
         * @return 实例对象
         */
        User queryById(Integer id);

        /**
         * 查询指定行数据
         *
         * @param offset 查询起始位置
         * @param limit 查询条数
         * @return 对象列表
         */
        List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


        /**
         * 通过实体作为筛选条件查询
         *
         * @param user 实例对象
         * @return 对象列表
         */
        List<User> queryAll(User user);

        /**
         * 新增数据
         *
         * @param user 实例对象
         * @return 影响行数
         */
        int insert(User user);

        /**
         * 修改数据
         *
         * @param id 实例对象
         * @return 影响行数
         */
        int update(int id);

        /**
         * 通过主键删除数据
         *
         * @param id 主键
         * @return 影响行数
         */
        int deleteById(Integer id);

        User queryByName(@Param("userName") String userName,@Param("password") String password);

}
