package com.sepbf.smartwarehouse.pojo;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("order_detail")
@Data
public class OrderDetail {

    private String orderID;

    private String businessName;

    private int productTypeNum;

    private int productQuantity;

    private float fee;

    private Date startTime;

    private Date endTime;

    public OrderDetail(String orderID, String businessName, int productTypeNum, int productQuantity, float fee, Date startTime, Date endTime) {
        this.orderID = orderID;
        this.businessName = businessName;
        this.productTypeNum = productTypeNum;
        this.productQuantity = productQuantity;
        this.fee = fee;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
