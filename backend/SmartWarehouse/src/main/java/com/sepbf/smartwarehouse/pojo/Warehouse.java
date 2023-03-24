package com.sepbf.smartwarehouse.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

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
