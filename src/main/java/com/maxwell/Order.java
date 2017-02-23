package com.maxwell;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2017/2/15 0015.
 */
public class Order {

    // 必须不为 null, 大小是 10
    @NotNull(message = "订单编号不能为空")
    @Size(min = 10, max = 10,message = "订单编号长度必须为10")
    private String orderId;
    // 必须不为空
    @NotEmpty(message = "客户不能为空")
    private String customer;
    // 必须是一个电子信箱地址
    @NotEmpty(message = "邮箱地址不能为空")
    @Email(message = "邮箱地址不合法")
    private String email;
    // 必须不为空
    @NotEmpty(message = "地址不能为空")
    private String address;

    @NotEmpty(message = "状态不能为空")
    private String status;

    @NotEmpty(message = "产品名称不能为空")
    private String pName;

    @NotEmpty(message = "价格不能为空")
    @Min(value = 0,message = "价格不能小于0")
    private  String price;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
