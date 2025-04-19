package com.example.subswh.controller;

import com.example.subswh.pojo.OrderItems;
import com.example.subswh.pojo.Orders;
import com.example.subswh.service.OrderItemsService;
import com.example.subswh.service.OrdersService;
import com.example.subswh.util.UniqueIDGenerator;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping
public class SubmitController {

    @Resource
    private OrdersService ordersService;
    @Resource
    private OrderItemsService orderItemsService;

    @PostMapping("/submit")
    public String submitOrder(@RequestBody Map<String, Object> map) throws ParseException {
        String seller = (String) map.get("seller");
        String startTimeStr = (String) map.get("start_time");
        String endTimeStr = (String) map.get("end_time");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse(startTimeStr);
        Date endTime = sdf.parse(endTimeStr);

        String orderId = UniqueIDGenerator.generateUUID();
        Orders order = new Orders(orderId, seller, startTime, endTime);
        System.out.println(order);
        ordersService.addOrder(order);

        List<Map<String, Object>> items = (List<Map<String, Object>>) map.get("items");
        for (Map<String, Object> item : items) {
            String productId = item.get("product_id").toString();
            String name = (String) item.get("name");
            String price = item.get("unit_price").toString();
            int quantity = ((Number) item.get("quantity")).intValue();

            OrderItems orderItems = new OrderItems(orderId, productId, name, price, quantity);
            System.out.println(orderItems);
            orderItemsService.addOrderItems(orderItems);
        }
        return "success";
    }
}
