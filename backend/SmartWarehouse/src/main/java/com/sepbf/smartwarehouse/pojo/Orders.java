package com.sepbf.smartwarehouse.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@TableName("orders")
@Data
public class Orders implements Serializable {

    private String order_id;

    private String product_id;

    private int quantity;

    private String warehouse_id;

    private String shelf_id;

    //构造函数
    public Orders(String order_id, String product_id, int quantity, String warehouse_id, String shelf_id) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.warehouse_id = warehouse_id;
        this.shelf_id = shelf_id;
    }
}
