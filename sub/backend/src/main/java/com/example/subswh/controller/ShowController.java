package com.example.subswh.controller;

import com.example.subswh.pojo.OrderItems;
import com.example.subswh.pojo.Orders;
import com.example.subswh.service.OrderItemsService;
import com.example.subswh.service.OrdersService;
import jakarta.annotation.Resource;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/4/24 21:21
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping
public class ShowController {

    @Resource
    private OrdersService ordersService;
    @Resource
    private OrderItemsService orderItemsService;

    //从前端接收到选中的订单号，找到和该订单有关的所有信息，返回给前端
    @PostMapping("/show")
    public Object show(@RequestBody Map<String, Object> map) {
        System.out.println("开始接收数据");
        String orderId = (String) map.get("order_id");
        System.out.println("order_id:" + orderId);

        // 获取符合条件的 OrderItems 列表
        List<OrderItems> orderItemsList = orderItemsService.getOrderItemsByOrderId(orderId);

        // 获取订单信息
        Orders order = ordersService.getOrderById(orderId);

        // 构造需要返回的数据结构
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("seller", "heyi");
        resultMap.put("orderid", order.getOrder_id());
        resultMap.put("start_time", order.getStart_time());
        resultMap.put("end_time", order.getEnd_time());

        List<Map<String, Object>> itemList = new ArrayList<>();
        for (OrderItems item : orderItemsList) {
            Map<String, Object> itemMap = new HashMap<>();
            itemMap.put("name", item.getName());
            itemMap.put("product_id", item.getProduct_id());
            itemMap.put("quantity", item.getQuantity());
            itemMap.put("unit_price", item.getUni_price());
            itemList.add(itemMap);
        }
        resultMap.put("items", itemList);

        // 转换为 JSON 格式并返回
        return new JSONObject(resultMap).toString();
    }


}
