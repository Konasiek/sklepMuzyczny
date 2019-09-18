package com.sklepmuzyczny.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;

    private String login;
    private String password;

    @OneToOne
    private Delivery delivery;

    public Customer() {
    }

    public Customer(Long customerId, String login, String password) {
        this.customerId = customerId;
        this.login = login;
        this.password = password;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
