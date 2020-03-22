package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.MovieInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 09:28
 * @Description
 */
@Repository
public interface MovieInfoMapper {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MovieInfo queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MovieInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param movieinfo 实例对象
     * @return 对象列表
     */
    List<MovieInfo> queryAll(MovieInfo movieinfo);

    /**
     * 新增数据
     *
     * @param movieinfo 实例对象
     * @return 影响行数
     */
    int insert(MovieInfo movieinfo);

    /**
     * 修改数据
     *
     * @param movieinfo 实例对象
     * @return 影响行数
     */
    boolean update(MovieInfo movieinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);
    /**
     * 按评分排序*/
    List<MovieInfo> queryOrderByScore();
}
