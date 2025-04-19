package com.example.subswh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.subswh.mapper.OrdersMapper;
import com.example.subswh.pojo.Orders;
import com.example.subswh.service.OrdersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/4/20 13:56
 */
@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public boolean addOrder(Orders orders) {
        return ordersMapper.insert(orders) > 0;
    }

    @Override
    public Orders getOrderById(String orderId) {
        return ordersMapper.selectById(orderId);
    }


}
