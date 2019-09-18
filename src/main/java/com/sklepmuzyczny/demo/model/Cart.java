package com.sklepmuzyczny.demo.model;


import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;


public class Cart {

    @ManyToOne
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    private List<Delivery> orders = new ArrayList<>();

    private Integer amount;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Delivery> getOrders() {
        return orders;
    }

    public void setOrders(List<Delivery> orders) {
        this.orders = orders;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
