package com.jackiedeng.movies.mapper;




import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/6 23:10
 * @Description
 */
@Repository
public interface RepositoryMapper {
        /**
         * 通过ID查询单条数据
         *
         * @param id 主键
         * @return 实例对象
         */
        com.jackiedeng.movies.pojo.Repository queryById(Integer id);

        /**
         * 查询多条数据
         *
         * @param offset 查询起始位置
         * @param limit 查询条数
         * @return 对象列表
         */
        List<com.jackiedeng.movies.pojo.Repository> queryAllByLimit(int offset, int limit);

        /**
         * 新增数据
         *
         * @param repository 实例对象
         * @return 实例对象
         */
        boolean insert(com.jackiedeng.movies.pojo.Repository repository);

        /**
         * 修改数据
         *
         * @param repository 实例对象
         * @return 实例对象
         */
        boolean update(com.jackiedeng.movies.pojo.Repository repository);

        /**
         * 通过主键删除数据
         *
         * @param id 主键
         * @return 是否成功
         */
        boolean deleteById(Integer id);


}
