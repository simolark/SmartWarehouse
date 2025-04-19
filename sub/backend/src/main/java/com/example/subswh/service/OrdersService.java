package com.example.subswh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.subswh.pojo.Orders;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/4/20 13:54
 */
public interface OrdersService extends IService<Orders> {
    boolean addOrder(Orders orders);
    Orders getOrderById(String orderId);

}
