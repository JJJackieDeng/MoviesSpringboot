package com.jackiedeng.movies.service;

import com.jackiedeng.movies.pojo.MovieInfo;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 09:29
 * @Description
 */
public interface MovieInfoService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MovieInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MovieInfo> queryAllByLimit(int offset, int limit);

    /**
     * 根据电影名称模糊查询电影
     * @param movieName
     */
    List<MovieInfo> queryAllByLikeName(String movieName);

    /**
     * 新增数据
     *
     * @param movieinfo 实例对象
     * @return 实例对象
     */
    boolean insert(MovieInfo movieinfo);

    /**
     * 修改数据
     *
     * @param movieinfo 实例对象
     * @return 实例对象
     */
    boolean update(MovieInfo movieinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<MovieInfo> queryOrderByScore();
}
