package com.example.subswh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.subswh.pojo.OrderItems;

import java.util.List;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/4/20 13:59
 */
public interface OrderItemsService extends IService<OrderItems> {

    boolean addOrderItems(OrderItems orderItems);

    List<OrderItems> getOrderItemsByOrderId(String order_id);

}
