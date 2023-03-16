package com.sepbf.smartwarehouse.pojo;

import java.sql.Timestamp;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@TableName("product")
@Data
public class Product {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Product(Integer id, String name, BigDecimal price, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
