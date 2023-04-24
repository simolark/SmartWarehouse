package com.sepbf.smartwarehouse.controller;

import com.sepbf.smartwarehouse.pojo.OrderDetail;
import com.sepbf.smartwarehouse.pojo.Orders;
import com.sepbf.smartwarehouse.service.OrdersDetailService;
import com.sepbf.smartwarehouse.service.OrdersService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghan
 */
@RestController
@RequestMapping("/store")
public class StorageController {

    @Resource
    private OrdersService orderService;

    @Resource
    private OrdersDetailService ordersDetailService;


    @PostMapping("/storeIn")
    public boolean storeIn(@RequestBody Map<String ,Object>map) throws ParseException {
        //获取前端json数据
        System.out.println(map);
        Orders tempOrders;
        OrderDetail tempOrderDetail;
        String seller = (String)map.get("seller");
        String orderid = (String)map.get("orderid");
        String tempDate = (String) map.get("start_time");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start_time = sdf.parse(tempDate);
        tempDate = (String) map.get("end_time");
        Date end_time = sdf.parse(tempDate);
        System.out.println(start_time);
        System.out.println(end_time);
        ArrayList item =  (ArrayList)map.get("items");
        System.out.println(item);
        int totalQuantity = 0;
        for(int i =0; i< item.size(); i++){

            HashMap tempMap = (HashMap) item.get(i);
            int tempQuantity = (int)tempMap.get("quantity");
            totalQuantity = totalQuantity + tempQuantity;
            System.out.println(tempMap);
            tempOrders = new Orders(seller,orderid, (String)tempMap.get("product_id"),(String)tempMap.get("name"),Float.parseFloat((String)tempMap.get("unit_price")),tempQuantity, "1","1");
            System.out.println(tempOrders);
            System.out.println(orderService.addOrder(tempOrders));
        }

        tempOrderDetail = new OrderDetail(seller, orderid, item.size(),totalQuantity,1,start_time,end_time);
        System.out.println(tempOrderDetail);
        System.out.println(ordersDetailService.addOderDetail(tempOrderDetail));


        return true;
    }

}
