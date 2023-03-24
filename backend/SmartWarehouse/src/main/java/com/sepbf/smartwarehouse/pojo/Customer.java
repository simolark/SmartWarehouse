package com.sepbf.smartwarehouse.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@TableName("customer")
@Data

public class Customer {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Customer(Integer id, String name, String address, String phone, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
