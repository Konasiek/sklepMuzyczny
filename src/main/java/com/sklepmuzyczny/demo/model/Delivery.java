package com.sklepmuzyczny.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    private Long deliveryId;

    @OneToOne
    private Customer customer;
}
