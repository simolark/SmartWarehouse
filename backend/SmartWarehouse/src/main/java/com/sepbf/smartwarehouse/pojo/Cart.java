package com.sepbf.smartwarehouse.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@TableName("cart")
@Data
public class Cart {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;
    private String type;
    private String status;
    private Integer batteryLevel;
    private Integer capacity;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Cart(Integer id, String name, String type, String status, Integer batteryLevel, Integer capacity, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.batteryLevel = batteryLevel;
        this.capacity = capacity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
