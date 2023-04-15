package com.sepbf.smartwarehouse.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.mapper.OrderMapper;
import com.sepbf.smartwarehouse.pojo.Orders;
import com.sepbf.smartwarehouse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hanjiang
 * @version 1.0
 * @date 2023/4/14 22:01
 */
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService  {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public boolean addOrder(Orders oder) {
        System.out.println(orderMapper.insert(oder));
        return true;
    }

}
