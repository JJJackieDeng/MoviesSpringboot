package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;



/**
 * (Score)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-04 22:57:37
 */
@Repository
@Mapper
public interface ScoreMapper {

    /**
     * 通过MOVIE_ID查询评分评论
     *
     * @param id 主键
     * @return 实例对象
     */
    List<Score> queryById(Integer id);

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

    /**
     * 通过movieId查询统计平均分并返回
     *
     * @param movieId 查询对象
     * @return 实例对象
     */
    Float queryAvgById(Integer movieId);

}