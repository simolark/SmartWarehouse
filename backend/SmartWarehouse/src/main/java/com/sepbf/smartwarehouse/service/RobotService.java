package com.sepbf.smartwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.smartwarehouse.pojo.Robot;

/**
 * RobotService接口，继承自MyBatis-Plus提供的IService接口
 */
public interface RobotService extends IService<Robot> {

    /**
     * 根据ID查询Robot信息
     *
     * @param id Robot的ID
     * @return 查询到的Cart对象，如果查询失败返回null
     */
    Robot getRobotById(Integer id);

    /**
     * 新增一条Robot记录
     *
     * @param robot 要新增的Robot对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    boolean addRobot(Robot robot);

    /**
     * 更新一条Robot记录
     *
     * @param robot 要更新的Robot对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    boolean updateRobot(Robot robot);

    /**
     * 根据ID删除一条Robot记录
     *
     * @param id Robot的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    boolean deleteRobot(Integer id);
}
