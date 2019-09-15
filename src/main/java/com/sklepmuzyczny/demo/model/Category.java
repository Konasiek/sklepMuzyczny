package com.sklepmuzyczny.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Category implements Serializable {


    @Id
    @GeneratedValue
    private Long CategoryId;
    private String nameCategory;

    @OneToMany
    private List<Product> listOfProducts = new ArrayList<>();
}
