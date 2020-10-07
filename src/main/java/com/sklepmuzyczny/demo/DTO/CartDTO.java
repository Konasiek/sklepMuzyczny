package com.sklepmuzyczny.demo.DTO;

import com.sklepmuzyczny.demo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {

    private Double totalPrice;

    private List<Product> products = new ArrayList<>();

    public CartDTO() {
    }

    public CartDTO(Double totalPrice, List<Product> products) {
        this.totalPrice = totalPrice;
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
