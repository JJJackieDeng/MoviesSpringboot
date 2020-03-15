package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.mapper.ScoreMapper;
import com.jackiedeng.movies.pojo.Score;
import com.jackiedeng.movies.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;



/**
 * (Score)表服务实现类
 *
 * @author makejava
 * @since 2020-03-04 22:57:37
 */
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Score queryById(Integer id) {
        return this.scoreMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Score> queryAllByLimit(int offset, int limit) {
        return this.scoreMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Score score) {
        try {
            this.scoreMapper.insert(score);
        } catch (Exception e) {
           return false;
        }
        return true;
    }

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Score score) {
        try {
            this.scoreMapper.update(score);
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
        return this.scoreMapper.deleteById(id) > 0;
    }
}