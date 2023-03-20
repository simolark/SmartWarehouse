package com.sepbf.smartwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.mapper.CartMapper;
import com.sepbf.smartwarehouse.mapper.GoodsMapper;
import com.sepbf.smartwarehouse.pojo.Goods;
import com.sepbf.smartwarehouse.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * GoodsService的实现类
 */
@Service
public class GoodsServiceImpl extends ServiceImpl <GoodsMapper, Goods> implements GoodsService {

    /**
     * 自动注入GoodsMapper对象
     */
    @Resource
    private GoodsMapper goodsMapper;


    /**
     * 根据ID查询Goods信息
     * @param id Goods的ID
     * @return 查询到的Goods对象，如果查询失败返回null
     */
    @Override
    public Goods getGoodsById(Integer id) {
        return goodsMapper.selectById(id);
    }


    /**
     * 新增一条Goods记录
     * @param goods 要新增的Goods对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    @Override
    public boolean addGoods(Goods goods) {
        return goodsMapper.insert(goods) > 0;
    }


    /**
     * 更新一条Goods记录
     * @param goods 要更新的Cart对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    @Override
    public boolean updateGoods(Goods goods) {
        return goodsMapper.updateById(goods) > 0;
    }

    /**
     * 根据ID删除一条Goods记录
     * @param id Goods的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    @Override
    public boolean deleteGoods(Integer id) {
        return goodsMapper.deleteById(id) > 0;
    }
}
