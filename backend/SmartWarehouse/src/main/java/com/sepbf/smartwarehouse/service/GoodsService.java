package com.sepbf.smartwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.smartwarehouse.pojo.Goods;

/**
 * GoodsService接口，继承自MyBatis-Plus提供的IService接口
 */
public interface GoodsService extends IService<Goods> {

    /**
     * 根据ID查询Goods信息
     *
     * @param id Goods的ID
     * @return 查询到的Goods对象，如果查询失败返回null
     */
    Goods getGoodsById(Integer id);


    /**
     * 新增一条Goods记录
     *
     * @param goods 要新增的Goods对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    boolean addGoods(Goods goods);

    /**
     * 更新一条Goods记录
     *
     * @param goods 要更新的Cart对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    boolean updateGoods(Goods goods);


    /**
     * 根据ID删除一条Goods记录
     *
     * @param id Goods的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    boolean deleteGoods(Integer id);
}