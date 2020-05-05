package com.jackiedeng.movies.service;

import com.jackiedeng.movies.pojo.MovieInfo;
import com.jackiedeng.movies.pojo.Schedule;

import java.util.Date;
import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 09:29
 * @Description
 */
public interface ScheduleService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Schedule queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Schedule> queryAllByLimit(int offset, int limit);

    /**
     * 根据日期查询场次*/
    List<Schedule> queryByDate(Date date,Integer movie_id,Integer cinema_id);

    /**
     * 新增数据
     *
     * @param schedule 实例对象
     * @return 实例对象
     */
    boolean insert(Schedule schedule);

    /**
     * 修改数据
     *
     * @param schedule 实例对象
     * @return 实例对象
     */
    boolean update(Schedule schedule);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
