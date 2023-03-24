package com.sepbf.smartwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.smartwarehouse.pojo.Warehouse;

/**
 * WarehouseService接口，继承自MyBatis-Plus提供的IService接口
 */
public interface WarehouseService extends IService<Warehouse> {

    /**
     * 根据ID查询Warehouse信息
     * @param id Warehouse的ID
     * @return 查询到的Warehouse对象，如果查询失败返回null
     */
    Warehouse getWarehouseById(Integer id);

    /**
     * 新增一条Warehouse记录
     * @param warehouse 要新增的Warehouse对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    boolean addWarehouse(Warehouse warehouse);

    /**
     * 更新一条Warehouse记录
     * @param warehouse 要更新的Warehouse对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    boolean updateWarehouse(Warehouse warehouse);

    /**
     * 根据ID删除一条Warehouse记录
     * @param id Warehouse的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    boolean deleteWarehouse(Integer id);
}
