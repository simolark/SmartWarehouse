package com.sepbf.smartwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.smartwarehouse.pojo.Cart;

/**
 * CartService接口，继承自MyBatis-Plus提供的IService接口
 */
public interface CartService extends IService<Cart> {

    /**
     * 根据ID查询Cart信息
     * @param id Cart的ID
     * @return 查询到的Cart对象，如果查询失败返回null
     */
    Cart getCartById(Integer id);

    /**
     * 新增一条Cart记录
     * @param cart 要新增的Cart对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    boolean addCart(Cart cart);

    /**
     * 更新一条Cart记录
     * @param cart 要更新的Cart对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    boolean updateCart(Cart cart);

    /**
     * 根据ID删除一条Cart记录
     * @param id Cart的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    boolean deleteCart(Integer id);
}