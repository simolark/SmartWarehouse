package com.sepbf.smartwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.mapper.CartMapper;
import com.sepbf.smartwarehouse.pojo.Cart;
import com.sepbf.smartwarehouse.service.CartService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * CartService的实现类
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    /**
     * 自动注入CartMapper对象
     */
    @Resource
    private CartMapper cartMapper;

    /**
     * 根据ID查询Cart信息
     * @param id Cart的ID
     * @return 查询到的Cart对象，如果查询失败返回null
     */
    @Override
    public Cart getCartById(Integer id) {
        return cartMapper.selectById(id);
    }

    /**
     * 新增一条Cart记录
     * @param cart 要新增的Cart对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    @Override
    public boolean addCart(Cart cart) {
        return cartMapper.insert(cart) > 0;
    }

    /**
     * 更新一条Cart记录
     * @param cart 要更新的Cart对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    @Override
    public boolean updateCart(Cart cart) {
        return cartMapper.updateById(cart) > 0;
    }

    /**
     * 根据ID删除一条Cart记录
     * @param id Cart的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    @Override
    public boolean deleteCart(Integer id) {
        return cartMapper.deleteById(id) > 0;
    }

}


