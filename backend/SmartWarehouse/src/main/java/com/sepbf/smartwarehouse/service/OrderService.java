package com.sepbf.smartwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.smartwarehouse.pojo.Orders;

/**
 * @author hanjiang
 * @version 1.0
 * @date 2023/4/14 22:01
 */
public interface OrderService extends IService<Orders> {

    boolean addOrder(Orders oder);

}
