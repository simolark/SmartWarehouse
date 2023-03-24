package com.sepbf.smartwarehouse.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@TableName("shelf")
@Data
public class Shelf {
    private Integer id;
    private String location;
    private String status;
    private Integer warehouseId;
    private Integer capacity;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Shelf(Integer id, String location, String status, Integer warehouseId, Integer capacity, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.location = location;
        this.status = status;
        this.warehouseId = warehouseId;
        this.capacity = capacity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
