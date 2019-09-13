package com.sklepmuzyczny.demo.model;

import lombok.Getter;
import lombok.Setter;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

//@Entity
@Getter
@Setter
public class User {

//    @Id
//    @GeneratedValue
    private Long userId;

    private String login;
    private String password;

    public User() {
    }

    public User(Long userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }
}
