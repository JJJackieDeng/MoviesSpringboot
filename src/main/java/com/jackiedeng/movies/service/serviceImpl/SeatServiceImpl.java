package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.mapper.SeatMapper;
import com.jackiedeng.movies.pojo.Seat;
import com.jackiedeng.movies.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 09:29
 * @Description
 */
@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatMapper seatMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Seat queryById(Integer id) {
        return this.seatMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Seat> queryAllByLimit(int offset, int limit) {
        return this.seatMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param seat 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Seat seat) {
        try {
            this.seatMapper.insert(seat);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 修改数据
     *
     * @param seat 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Seat seat) {
        try {
            this.seatMapper.update(seat);
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
            this.seatMapper.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
