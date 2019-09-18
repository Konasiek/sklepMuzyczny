package com.sklepmuzyczny.demo.DTO;

public class ProductDTO {

    private Long productId;
    private Double productPrice;
    private String productName;
    private String manufactureName;


    public ProductDTO(Long productId, Double productPrice, String productName, String manufactureName) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.manufactureName = manufactureName;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
}

