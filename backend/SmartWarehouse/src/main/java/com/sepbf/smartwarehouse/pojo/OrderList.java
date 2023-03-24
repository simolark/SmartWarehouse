package com.sepbf.smartwarehouse.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;


@TableName("order_list")
@Data
public class OrderList {
    private Integer id;
    private Integer customerId;
    private Integer productId;
    private Integer quantity;
    private BigDecimal amount;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public OrderList(Integer id, Integer customerId, Integer productId, Integer quantity, BigDecimal amount, String status, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
