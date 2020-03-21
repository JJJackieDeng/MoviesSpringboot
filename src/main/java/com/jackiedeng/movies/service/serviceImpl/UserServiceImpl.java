package com.jackiedeng.movies.service.serviceImpl;

import com.jackiedeng.movies.mapper.UserMapper;
import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/6 23:26
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(User user) {
        try {
            this.userMapper.insert(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(User user) {
        try {
            this.userMapper.update(user);
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
            this.userMapper.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return true;
    }

    @Override
    public Result login(User user) {
        Result result = new Result(404,null,user);
        try {
            User userName = userMapper.queryByName(user.getUserName());
            if (userName == null) {
                result.setMessage("用户名或密码错误");
            } else {
                result.setMessage("登录成功");
                result.setCode(200);
                result.setData(user);
            }
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public User queryByName(String userName) {
        User user = userMapper.queryByName(userName);
        if (user != null) {
            return user;
        }
        return null;
    }

    /**
     * 根据用户名称模糊查询
     *
     * @param userName
     */
    @Override
    public User selectByLikeName(String userName) {
        return this.userMapper.selectByLikeName(userName);
    }
}
