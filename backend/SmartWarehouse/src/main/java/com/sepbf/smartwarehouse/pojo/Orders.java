package com.sepbf.smartwarehouse.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("orders")
@Data
public class Orders implements Serializable {

    private String seller;

    private String order_id;

    private String product_id;

    private String product_name;

    private float unit_price;

    private int quantity;

    private String warehouse_id;

    private String shelf_id;

    //构造函数
    public Orders(String seller, String order_id, String product_id, String product_name,float unit_price,int quantity, String warehouse_id, String shelf_id) {
        this.seller = seller;
        this.order_id = order_id;
        this.product_name = product_name;
        this.unit_price = unit_price;
        this.product_id = product_id;
        this.quantity = quantity;
        this.warehouse_id = warehouse_id;
        this.shelf_id = shelf_id;
    }
}
