package com.sepbf.smartwarehouse.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.config.Result;
import com.sepbf.smartwarehouse.config.Result.ResultCode;
import com.sepbf.smartwarehouse.pojo.Goods;
import com.sepbf.smartwarehouse.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    /**
     * 根据ID查询Goods信息
     * @param id Goods的ID
     * @return 查询到的Goods对象，如果查询失败返回错误结果对象
     */
    @Override
    public Result<Goods> getGoodsById(Integer id) {
        Goods goods = this.getById(id);
        if (goods == null) {
            return Result.error(ResultCode.NOT_FOUND, "Goods not found");
        }
        return Result.success(goods);
    }

    /**
     * 新增一条Goods记录
     * @param goods 要新增的Goods对象
     * @return 返回值为成功结果对象或失败结果对象
     */
    @Override
    public Result<Void> addGoods(Goods goods) {
        boolean isSuccess = this.save(goods);
        if (!isSuccess) {
            return Result.failure();
        }
        return Result.success();
    }

    /**
     * 更新一条Goods记录
     * @param goods 要更新的Goods对象
     * @return 返回值为成功结果对象或失败结果对象
     */
    @Override
    public Result<Void> updateGoods(Goods goods) {
        boolean isSuccess = this.updateById(goods);
        if (!isSuccess) {
            return Result.failure();
        }
        return Result.success();
    }

    /**
     * 根据ID删除一条Goods记录
     * @param id Goods的ID
     * @return 返回值为成功结果对象或失败结果对象
     */
    @Override
    public Result<Void> deleteGoods(Integer id) {
        boolean isSuccess = this.removeById(id);
        if (!isSuccess) {
            return Result.failure();
        }
        return Result.success();
    }

}

