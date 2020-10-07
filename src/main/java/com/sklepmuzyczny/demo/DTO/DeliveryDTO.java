package com.sklepmuzyczny.demo.DTO;

import com.sklepmuzyczny.demo.model.Cart;
import com.sklepmuzyczny.demo.model.User;


public class DeliveryDTO {


    private String city;
    private String street;
    private User user;
    private Cart cart;

    public DeliveryDTO() {
    }

    public DeliveryDTO(String city, String street, User user, Cart cart) {
        this.city = city;
        this.street = street;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
