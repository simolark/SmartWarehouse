package com.sepbf.smartwarehouse.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("order")
@Data
public class Order {

    private String orderID;

    private String productID;

    private int quantity;

    private String warehouseID;

    private String shelfID;

    public Order(String orderID, String productID, int quantity, String warehouseID, String shelfID) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.warehouseID = warehouseID;
        this.shelfID = shelfID;
    }
}
