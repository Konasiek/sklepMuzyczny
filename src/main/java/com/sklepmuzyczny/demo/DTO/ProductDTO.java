package com.sklepmuzyczny.demo.DTO;

import com.sklepmuzyczny.demo.model.Category;

public class ProductDTO {

    private Double productPrice;
    private String productName;
    private String manufactureName;
    private Category category;

    public ProductDTO(Double productPrice, String productName, String manufactureName, Category category) {
        this.productPrice = productPrice;
        this.productName = productName;
        this.manufactureName = manufactureName;
        this.category = category;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufactureName() {
        return manufactureName;
    }

    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

