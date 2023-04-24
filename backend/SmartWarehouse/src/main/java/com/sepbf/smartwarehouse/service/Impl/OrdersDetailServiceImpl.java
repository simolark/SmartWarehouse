package com.sepbf.smartwarehouse.service.Impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.mapper.OrderDetailMapper;
import com.sepbf.smartwarehouse.pojo.OrderDetail;
import com.sepbf.smartwarehouse.service.OrdersDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hanjiang
 * @version 1.0
 * @date 2023/4/15 22:01
 */
@Service("ordersDetailService")
public class OrdersDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrdersDetailService {

    @Resource
    OrderDetailMapper orderDetailMapper;


    @Override
    public boolean addOderDetail(OrderDetail orderDetail) {
        System.out.println(orderDetailMapper.insert(orderDetail));
        return true;
    }
}
