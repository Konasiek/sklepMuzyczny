package com.sklepmuzyczny.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;

    private String login;
    private String password;

    public Customer() {
    }

    public Customer(Long customerId, String login, String password) {
        this.customerId = customerId;
        this.login = login;
        this.password = password;
    }
}
