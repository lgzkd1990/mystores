package com.zl.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private String oid;
    private String ordertime;
    private double total;
    private Integer state;
    private String address;
    private String name;
    private String telephone;
    private User user;
    List<OrdersItem> list =new ArrayList<>();

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telphone) {
        this.telephone = telphone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrdersItem> getList() {
        return list;
    }

    public void setList(List<OrdersItem> list) {
        this.list = list;
    }
}
