package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.Cinema;
import com.jackiedeng.movies.pojo.MovieInfo;
import org.apache.ibatis.annotations.Mapper;
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
@Mapper
public interface CinemaMapper {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cinema queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Cinema> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据影院名称模糊查询影院*/
    List<Cinema> queryByName(String cinemaName);

    /**
     * 根据影院名称模糊查询影院*/
    List<Cinema> queryByAddress(String address);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param cinema 实例对象
     * @return 对象列表
     */
    List<Cinema> queryAll(Cinema cinema);

    /**
     * 新增数据
     *
     * @param cinema 实例对象
     * @return 影响行数
     */
    boolean insert(Cinema cinema);

    /**
     * 修改数据
     *
     * @param cinema 实例对象
     * @return 影响行数
     */
    boolean update(Cinema cinema);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    boolean deleteById(Integer id);
}
