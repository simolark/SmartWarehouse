package com.sepbf.smartwarehouse.pojo;

import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@TableName("warehouse")
@Data
public class Warehouse {
    private Integer id;
    private String name;
    private Integer totalCapacity;
    private Integer usedCapacity;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Warehouse(Integer id, String name, Integer totalCapacity, Integer usedCapacity, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.usedCapacity = usedCapacity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
