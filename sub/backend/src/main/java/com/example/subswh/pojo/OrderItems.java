package com.example.subswh.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/4/20 13:49
 */
@TableName("order_items")
@Data
public class OrderItems {

    private String order_id;
    private String product_id;
    private String name;
    private String uni_price;
    private int quantity;

    public OrderItems(String order_id, String product_id, String name, String uni_price, int quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.name = name;
        this.uni_price = uni_price;
        this.quantity = quantity;
    }

    public String toString() {
        return "order_id: " + order_id + ", product_id: " + product_id + ", name: " + name + ", uni_price: " + uni_price + ", quantity: " + quantity;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUni_price() {
        return uni_price;
    }

    public void setUni_price(String uni_price) {
        this.uni_price = uni_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
