package com.sepbf.smartwarehouse.pojo;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("order_detail")
@Data
public class OrderDetail {

    private String seller;

    private String order_id;

    private int product_type_num;

    private int product_quantity;

    private float fee;

    private Date start_time;

    private Date end_time;

    //构造函数
    public OrderDetail(String seller,String order_id,  int product_type_num, int product_quantity, float fee, Date start_time, Date end_time) {
        this.seller = seller;
        this.order_id = order_id;
        this.product_type_num = product_type_num;
        this.product_quantity = product_quantity;
        this.fee = fee;
        this.start_time = start_time;
        this.end_time = end_time;
    }

}
