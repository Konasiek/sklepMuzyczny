package com.sklepmuzyczny.demo.products;

import com.sklepmuzyczny.demo.categories.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

    @OneToOne
    private Category category;


}
