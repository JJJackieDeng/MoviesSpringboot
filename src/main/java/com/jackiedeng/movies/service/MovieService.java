package com.jackiedeng.movies.service;


import com.jackiedeng.movies.pojo.Movie;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 00:28
 * @Description
 */
public interface MovieService {
    List<Movie> findAll();
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    int queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Movie> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param
     */
    int insert(int id);

    /**
     * 修改数据
     * @param id 根据id更新数据
     */
    int update(int id);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
