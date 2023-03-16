package com.sepbf.smartwarehouse.pojo;

import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@TableName("goods")
@Data
public class Goods {
    private Integer id;
    private String name;
    private Integer quantity;
    private String location;
    private Integer shelfId;
    private Integer orderId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Goods(Integer id, String name, Integer quantity, String location, Integer shelfId, Integer orderId, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
        this.shelfId = shelfId;
        this.orderId = orderId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
