package com.sepbf.smartwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.mapper.ShelfMapper;
import com.sepbf.smartwarehouse.pojo.Shelf;
import com.sepbf.smartwarehouse.service.ShelfService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * ShelfService的实现类
 */
@Service
public class ShelfServiceImpl extends ServiceImpl<ShelfMapper, Shelf> implements ShelfService {

    /**
     * 自动注入ShelfMapper对象
     */
    @Resource
    private ShelfMapper shelfMapper;

    /**
     * 根据ID查询Shelf信息
     *
     * @param id Shelf的ID
     * @return 查询到的Shelf对象，如果查询失败返回null
     */
    @Override
    public Shelf getShelfById(Integer id) {
        return shelfMapper.selectById(id);
    }

    /**
     * 新增一条Shelf记录
     *
     * @param shelf 要新增的Shelf对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    @Override
    public boolean addShelf(Shelf shelf) {
        return shelfMapper.insert(shelf) > 0;
    }

    /**
     * 更新一条Shelf记录
     *
     * @param shelf 要更新的Shelf对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    @Override
    public boolean updateShelf(Shelf shelf) {
        return shelfMapper.updateById(shelf) > 0;
    }

    /**
     * 根据ID删除一条Shelf记录
     *
     * @param id Shelf的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    @Override
    public boolean deleteShelf(Integer id) {
        return shelfMapper.deleteById(id) > 0;
    }

}


