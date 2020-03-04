package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;



/**
 * (Score)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-04 22:57:37
 */
public interface ScoreMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Score queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Score> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param score 实例对象
     * @return 对象列表
     */
    List<Score> queryAll(Score score);

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 影响行数
     */
    int insert(Score score);

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 影响行数
     */
    int update(Score score);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}