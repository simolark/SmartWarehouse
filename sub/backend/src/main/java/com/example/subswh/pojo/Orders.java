package com.example.subswh.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/4/20 13:44
 */
@TableName("orders")
@Data
public class Orders {

    private String order_id;
    private String seller;
    private Date start_time;
    private Date end_time;

    public Orders(String order_id, String seller, Date start_time, Date end_time) {
        this.order_id = order_id;
        this.seller = seller;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public String toString() {
        return "order_id: " + order_id + ", response: " + seller + ", start_time: " + start_time + ", end_time: " + end_time;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}
