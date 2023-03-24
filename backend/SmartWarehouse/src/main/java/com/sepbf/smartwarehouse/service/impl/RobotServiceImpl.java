package com.sepbf.smartwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.mapper.RobotMapper;
import com.sepbf.smartwarehouse.pojo.Robot;
import com.sepbf.smartwarehouse.service.RobotService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * RobotService的实现类
 */
@Service
public class RobotServiceImpl extends ServiceImpl<RobotMapper, Robot> implements RobotService {

    /**
     * 自动注入RobotMapper对象
     */
    @Resource
    private RobotMapper robotMapper;

    /**
     * 根据ID查询Robot信息
     *
     * @param id Robot的ID
     * @return 查询到的Robot对象，如果查询失败返回null
     */
    @Override
    public Robot getRobotById(Integer id) {
        return robotMapper.selectById(id);
    }

    /**
     * 新增一条Robot记录
     *
     * @param robot 要新增的Robot对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    @Override
    public boolean addRobot(Robot robot) {
        return robotMapper.insert(robot) > 0;
    }

    /**
     * 更新一条Robot记录
     *
     * @param robot 要更新的Robot对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    @Override
    public boolean updateRobot(Robot robot) {
        return robotMapper.updateById(robot) > 0;
    }

    /**
     * 根据ID删除一条Robot记录
     *
     * @param id Robot的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    @Override
    public boolean deleteRobot(Integer id) {
        return robotMapper.deleteById(id) > 0;
    }

}


