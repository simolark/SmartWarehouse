package com.sepbf.smartwarehouse.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.mapper.OrdersMapper;
import com.sepbf.smartwarehouse.pojo.Orders;
import com.sepbf.smartwarehouse.service.OrdersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author hanjiang
 * @version 1.0
 * @date 2023/4/14 22:01
 */
@Service("orderService")
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Resource
    OrdersMapper orderMapper;

    @Override
    public boolean addOrder(Orders order) {
        System.out.println(orderMapper.insert(order));
        return true;
    }

}
