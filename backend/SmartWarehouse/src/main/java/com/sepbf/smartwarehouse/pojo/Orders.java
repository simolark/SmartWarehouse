package com.sepbf.smartwarehouse.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@TableName("orders")
@Data
public class Orders implements Serializable {

    private String orderid;

    private String productid;

    private int quantity;

    private String warehouseid;

    private String shelfid;

    public Orders(String orderid, String productid, int quantity, String warehouseid, String shelfid) {
        this.orderid = orderid;
        this.productid = productid;
        this.quantity = quantity;
        this.warehouseid = warehouseid;
        this.shelfid = shelfid;
    }
}
