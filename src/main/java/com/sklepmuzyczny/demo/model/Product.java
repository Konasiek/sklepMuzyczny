package com.sklepmuzyczny.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private Long productId;
    private Double productPrice;
    private String productName;
    private String manufacturerName;

    @ManyToOne
    private Category category;

    public Product() {
    }


}
