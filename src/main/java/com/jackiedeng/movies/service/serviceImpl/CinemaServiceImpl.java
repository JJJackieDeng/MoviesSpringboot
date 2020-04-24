package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.mapper.CinemaMapper;
import com.jackiedeng.movies.mapper.MovieInfoMapper;
import com.jackiedeng.movies.pojo.Cinema;
import com.jackiedeng.movies.pojo.MovieInfo;
import com.jackiedeng.movies.service.CinemaService;
import com.jackiedeng.movies.service.MovieInfoService;
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
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    CinemaMapper cinemaMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Cinema queryById(Integer id) {
        return this.cinemaMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Cinema> queryAllByLimit(int offset, int limit) {
        return this.cinemaMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param cinema 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Cinema cinema) {
        try {
            this.cinemaMapper.insert(cinema);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 修改数据
     *
     * @param cinema 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Cinema cinema) {
        try {
            this.cinemaMapper.update(cinema);
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
            this.cinemaMapper.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 根据影院名称模糊查询影院
     *
     * @param cinemaName
     */
    @Override
    public List<Cinema> queryByName(String cinemaName) {
        return cinemaMapper.queryByName(cinemaName);
    }
}
