package com.sepbf.smartwarehouse.controller;

import com.sepbf.smartwarehouse.pojo.Orders;
import com.sepbf.smartwarehouse.service.OrdersService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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


    @PostMapping("/storeIn")
    public boolean storeIn(@RequestBody Map<String ,Object>map){
        //获取前端json数据
        System.out.println(map);
        Orders tempOrders;
        ArrayList item =  (ArrayList)map.get("items");
        System.out.println(item);
        for(int i =0; i< item.size(); i++){

            HashMap tempMap = (HashMap) item.get(i);
            System.out.println(tempMap);
            tempOrders = new Orders((String) tempMap.get("orderID"), (String)tempMap.get("product_id"),(int)tempMap.get("quantity"), (String)tempMap.get("warehouseID"),(String)tempMap.get("shelfID"));
            System.out.println(tempOrders);
            System.out.println(orderService.addOrder(tempOrders));
        }

        return true;
    }

}
