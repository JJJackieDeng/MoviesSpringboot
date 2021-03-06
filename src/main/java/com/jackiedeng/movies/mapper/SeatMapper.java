package com.jackiedeng.movies.mapper;

import com.jackiedeng.movies.pojo.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/20 17:24
 * @Description
 */
@Repository
@Mapper
public interface SeatMapper {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<Seat> queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Seat> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param seat 实例对象
     * @return 实例对象
     */
    boolean insert(Seat seat);

    /**
     * 修改数据
     *
     * @param seat 实例对象
     * @return 实例对象
     */
    boolean update(Seat seat);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    /**
     * 批量插入*/
    boolean insertBatch(List<Seat> seat);

    Integer toInsert(@Param(value = "seatId")List<String> seatID);
}
