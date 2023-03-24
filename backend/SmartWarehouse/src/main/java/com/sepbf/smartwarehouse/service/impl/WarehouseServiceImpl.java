package com.sepbf.smartwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.mapper.WarehouseMapper;
import com.sepbf.smartwarehouse.pojo.Warehouse;
import com.sepbf.smartwarehouse.service.WarehouseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * CartService的实现类
 */
@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements WarehouseService {

    /**
     * 自动注入WarehouseMapper对象
     */
    @Resource
    private WarehouseMapper warehouseMapper;

    /**
     * 根据ID查询Warehouse信息
     *
     * @param id Warehouse的ID
     * @return 查询到的Warehouse对象，如果查询失败返回null
     */
    @Override
    public Warehouse getWarehouseById(Integer id) {
        return warehouseMapper.selectById(id);
    }

    /**
     * 新增一条Warehouse记录
     *
     * @param warehouse 要新增的Warehouse对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    @Override
    public boolean addWarehouse(Warehouse warehouse) {
        return warehouseMapper.insert(warehouse) > 0;
    }

    /**
     * 更新一条Warehouse记录
     *
     * @param warehouse 要更新的Warehouse对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    @Override
    public boolean updateWarehouse(Warehouse warehouse) {
        return warehouseMapper.updateById(warehouse) > 0;
    }

    /**
     * 根据ID删除一条Warehouse记录
     *
     * @param id Warehouse的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    @Override
    public boolean deleteWarehouse(Integer id) {
        return warehouseMapper.deleteById(id) > 0;
    }

}


