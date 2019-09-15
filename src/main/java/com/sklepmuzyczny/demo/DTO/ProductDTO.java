package com.sklepmuzyczny.demo.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long productId;
    private Double productPrice;
    private String productName;
    private String manufactureName;


    // FOREIGN KEY //  ?????????????
//    private Long categoryId;


    public ProductDTO(Long productId, Double productPrice, String productName, String manufactureName) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.manufactureName = manufactureName;
    }
}

