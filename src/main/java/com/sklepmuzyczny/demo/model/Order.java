package com.sklepmuzyczny.demo.model;

import lombok.Getter;
import lombok.Setter;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;

//@Entity
@Getter
@Setter
public class Order {

//    @Id
//    @GeneratedValue
    private Long orderId;

//    @OneToOne
    private User user;
}
