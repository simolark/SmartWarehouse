package com.sepbf.smartwarehouse.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.config.Result;
import com.sepbf.smartwarehouse.config.Result.ResultCode;
import com.sepbf.smartwarehouse.pojo.Cart;
import com.sepbf.smartwarehouse.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    /**
     * 根据ID查询Cart信息
     * @param id Cart的ID
     * @return 查询到的Cart对象，如果查询失败返回错误结果对象
     */
    @Override
    public Result<Cart> getCartById(Integer id) {
        Cart cart = this.getById(id);
        if (cart == null) {
            return Result.error(ResultCode.NOT_FOUND, "Cart not found");
        }
        return Result.success(cart);
    }

    /**
     * 新增一条Cart记录
     * @param cart 要新增的Cart对象
     * @return 返回值为成功结果对象或失败结果对象
     */
    @Override
    public Result<Void> addCart(Cart cart) {
        boolean isSuccess = this.save(cart);
        if (!isSuccess) {
            return Result.failure();
        }
        return Result.success();
    }

    /**
     * 更新一条Cart记录
     * @param cart 要更新的Cart对象
     * @return 返回值为成功结果对象或失败结果对象
     */
    @Override
    public Result<Void> updateCart(Cart cart) {
        boolean isSuccess = this.updateById(cart);
        if (!isSuccess) {
            return Result.failure();
        }
        return Result.success();
    }

    /**
     * 根据ID删除一条Cart记录
     * @param id Cart的ID
     * @return 返回值为成功结果对象或失败结果对象
     */
    @Override
    public Result<Void> deleteCart(Integer id) {
        boolean isSuccess = this.removeById(id);
        if (!isSuccess) {
            return Result.failure();
        }
        return Result.success();
    }

}
