package com.sepbf.smartwarehouse.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@TableName("orders")
@Data
public class Orders implements Serializable {

    @Column(name = "OrderID")
    private String orderID;

    private String productID;

    private int quantity;

    private String warehouseID;

    private String shelfID;

    public Orders(String orderID, String productID, int quantity, String warehouseID, String shelfID) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.warehouseID = warehouseID;
        this.shelfID = shelfID;
    }
}
