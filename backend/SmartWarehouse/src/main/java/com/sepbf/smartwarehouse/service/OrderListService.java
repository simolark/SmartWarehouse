package com.sepbf.smartwarehouse.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.smartwarehouse.pojo.OrderList;


/**
 * OrderListService接口，继承自MyBatis-Plus的IService接口
 */
public interface OrderListService extends IService<OrderList> {

    /**
     * 根据ID查询OrderList信息
     *
     * @param id OrderList的ID
     * @return 查询到的OrderList对象，如果查询失败返回null
     */
    OrderList getOrderListById(Integer id);

    /**
     * 新增一条OrderList记录
     *
     * @param orderList 要新增的OrderList对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    boolean addOrderList(OrderList orderList);

    /**
     * 更新一条OrderList记录
     *
     * @param orderList 要更新的OrderList对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    boolean updateOrderList(OrderList orderList);

    /**
     * 根据ID删除一条OrderList记录
     *
     * @param id OrderList的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    boolean deleteOrderList(Integer id);
}

