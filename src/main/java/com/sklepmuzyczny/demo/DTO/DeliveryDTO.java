package com.sklepmuzyczny.demo.DTO;

import com.sklepmuzyczny.demo.model.Cart;
import com.sklepmuzyczny.demo.model.Customer;


public class DeliveryDTO {


    private String city;
    private String street;
    private Customer customer;
    private Cart cart;

    public DeliveryDTO() {
    }

    public DeliveryDTO(String city, String street, Customer customer, Cart cart) {
        this.city = city;
        this.street = street;
        this.customer = customer;
        this.cart = cart;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
