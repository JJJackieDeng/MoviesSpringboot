package com.jackiedeng.movies.service;

import com.jackiedeng.movies.pojo.Repository;
import com.jackiedeng.movies.pojo.Score;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/18 22:06
 * @Description
 */
public interface RepositoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Repository queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Repository> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param repository 实例对象
     * @return 实例对象
     */
    boolean insert(Repository repository);

    /**
     * 修改数据
     *
     * @param repository 实例对象
     * @return 实例对象
     */
    boolean update(Repository repository);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
