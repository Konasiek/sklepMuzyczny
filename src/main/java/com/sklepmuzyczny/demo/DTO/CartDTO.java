package com.sklepmuzyczny.demo.DTO;

import com.sklepmuzyczny.demo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {

    private Integer amount;

    private List<Product> products = new ArrayList<>();

    public CartDTO() {
    }

    public CartDTO(Integer amount, List<Product> products) {
        this.amount = amount;
        this.products = products;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
