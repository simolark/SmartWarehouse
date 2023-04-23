package com.sepbf.smartwarehouse.pojo;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("order_detail")
@Data
public class OrderDetail {


    private String order_id;

    private String business_name;

    private int product_type_num;

    private int product_quantity;

    private float fee;

    private Date start_time;

    private Date end_time;

    //构造函数
    public OrderDetail(String order_id, String business_name, int product_type_num, int product_quantity, float fee, Date start_time, Date end_time) {
        this.order_id = order_id;
        this.business_name = business_name;
        this.product_type_num = product_type_num;
        this.product_quantity = product_quantity;
        this.fee = fee;
        this.start_time = start_time;
        this.end_time = end_time;
    }

}
