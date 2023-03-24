package com.sepbf.smartwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.smartwarehouse.pojo.Shelf;


/**
 * ShelfService接口，继承自MyBatis-Plus提供的IService接口
 */
public interface ShelfService extends IService<Shelf> {

    /**
     * 根据ID查询Shelf信息
     *
     * @param id Shelf的ID
     * @return 查询到的Shelf对象，如果查询失败返回null
     */
    Shelf getShelfById(Integer id);


    /**
     * 新增一条Shelf记录
     *
     * @param shelf 要新增的Shelf对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    boolean addShelf(Shelf shelf);

    /**
     * 更新一条Shelf记录
     *
     * @param shelf 要更新的Shelf对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    boolean updateShelf(Shelf shelf);

    /**
     * 根据ID删除一条Shelf记录
     *
     * @param id Shelf的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    boolean deleteShelf(Integer id);
}
