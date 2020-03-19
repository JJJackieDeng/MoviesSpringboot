package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.mapper.OrderMapper;
import com.jackiedeng.movies.mapper.RepositoryMapper;
import com.jackiedeng.movies.pojo.Order;
import com.jackiedeng.movies.pojo.Repository;
import com.jackiedeng.movies.service.OrderService;
import com.jackiedeng.movies.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/11 23:48
 * @Description
 */
@Service
public class RepositoryServiceImpl implements RepositoryService {
    @Autowired
    RepositoryMapper repositoryMapper;
    //列
    public static final int COL=10;
    //行
    public static final int ROW=20;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Repository queryById(Integer id) {
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Repository> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param repository 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Repository repository) {
        return false;
    }

    /**
     * 修改数据
     *
     * @param repository 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Repository repository) {
        return false;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
