package com.jackiedeng.movies.service;

import com.jackiedeng.movies.pojo.Score;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/4 22:49
 * @Description
 */
public interface ScoreService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Score queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Score> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    Score insert(Score score);

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    Score update(Score score);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
