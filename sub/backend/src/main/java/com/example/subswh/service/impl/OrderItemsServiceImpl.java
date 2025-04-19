package com.example.subswh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.subswh.mapper.OrderItemsMapper;
import com.example.subswh.pojo.OrderItems;
import com.example.subswh.service.OrderItemsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/4/20 14:00
 */
@Service("orderItemsService")
public class OrderItemsServiceImpl extends ServiceImpl<OrderItemsMapper, OrderItems> implements OrderItemsService {

    @Resource
    private OrderItemsMapper orderItemsMapper;

    @Override
    public boolean addOrderItems(OrderItems orderItems) {
        return orderItemsMapper.insert(orderItems) > 0;
    }

    @Override
    public List<OrderItems> getOrderItemsByOrderId(String orderId) {
        QueryWrapper<OrderItems> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        return orderItemsMapper.selectList(queryWrapper);
    }



}
