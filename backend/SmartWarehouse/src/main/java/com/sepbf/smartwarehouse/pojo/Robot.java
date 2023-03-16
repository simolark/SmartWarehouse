package com.sepbf.smartwarehouse.pojo;

import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@TableName("robot")
@Data
public class Robot {
    private Integer id;
    private String name;
    private String type;
    private String status;
    private Integer batteryLevel;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Robot(Integer id, String name, String type, String status, Integer batteryLevel, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.batteryLevel = batteryLevel;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
