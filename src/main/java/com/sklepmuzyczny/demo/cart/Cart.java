package com.sklepmuzyczny.demo.cart;

import com.sklepmuzyczny.demo.orders.Order;
import com.sklepmuzyczny.demo.products.Product;
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
    private List<Order> orders = new ArrayList<>();

}
