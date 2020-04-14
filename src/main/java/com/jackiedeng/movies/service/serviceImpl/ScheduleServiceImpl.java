package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.mapper.ScheduleMapper;
import com.jackiedeng.movies.pojo.Schedule;
import com.jackiedeng.movies.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/17 23:23
 * @Description
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Schedule queryById(Integer id) {
        return scheduleMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Schedule> queryAllByLimit(int offset, int limit) {
        return this.scheduleMapper.queryAllByLimit(offset,limit);
    }

    /**
     * 根据日期查询场次
     *
     * @param date
     */
    @Override
    public List<Schedule> queryByDate(Date date,Integer movie_id) {
        return scheduleMapper.queryByDate(date,movie_id);
    }

    /**
     * 新增数据
     *
     * @param schedule 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Schedule schedule) {
        try {
            this.scheduleMapper.insert(schedule);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    /**
     * 修改数据
     *
     * @param schedule 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Schedule schedule) {
        try {
            this.scheduleMapper.update(schedule);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        try {
            this.scheduleMapper.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
