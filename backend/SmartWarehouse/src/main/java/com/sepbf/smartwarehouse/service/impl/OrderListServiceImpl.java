package com.sepbf.smartwarehouse.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.mapper.OrderListMapper;
import com.sepbf.smartwarehouse.pojo.OrderList;
import com.sepbf.smartwarehouse.service.OrderListService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * OrderListService的实现类
 */
@Service
public class OrderListServiceImpl extends ServiceImpl<OrderListMapper, OrderList> implements OrderListService {

    /**
     * 自动注入OrderListMapper对象
     */
    @Resource
    private OrderListMapper orderListMapper;

    /**
     * 根据ID查询OrderList信息
     *
     * @param id OrderList的ID
     * @return 查询到的OrderList对象，如果查询失败返回null
     */
    @Override
    public OrderList getOrderListById(Integer id) {
        return orderListMapper.selectById(id);
    }

    /**
     * 新增一条OrderList记录
     *
     * @param orderList 要新增的OrderList对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    @Override
    public boolean addOrderList(OrderList orderList) {
        return orderListMapper.insert(orderList) > 0;
    }

    /**
     * 更新一条OrderList记录
     *
     * @param orderList 要更新的OrderList对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    @Override
    public boolean updateOrderList(OrderList orderList) {
        return orderListMapper.updateById(orderList) > 0;
    }

    /**
     * 根据ID删除一条OrderList记录
     *
     * @param id OrderList的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    @Override
    public boolean deleteOrderList(Integer id) {
        return orderListMapper.deleteById(id) > 0;
    }
}

