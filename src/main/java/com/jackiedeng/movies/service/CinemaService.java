package com.jackiedeng.movies.service;

import com.jackiedeng.movies.pojo.Cinema;
import com.jackiedeng.movies.pojo.MovieInfo;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 09:29
 * @Description
 */
public interface CinemaService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cinema queryById(Integer id);
    /**
     * 根据影院名称模糊查询影院*/
    List<Cinema> queryByName(String cinemaName);

    /**
     * 根据影院名称模糊查询影院*/
    List<Cinema> queryByAddress(String address);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Cinema> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param cinema 实例对象
     * @return 实例对象
     */
    boolean insert(Cinema cinema);

    /**
     * 修改数据
     *
     * @param cinema 实例对象
     * @return 实例对象
     */
    boolean update(Cinema cinema);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
