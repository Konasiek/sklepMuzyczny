package com.sklepmuzyczny.demo.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart {

    @ManyToOne
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    private List<Delivery> orders = new ArrayList<>();

}
