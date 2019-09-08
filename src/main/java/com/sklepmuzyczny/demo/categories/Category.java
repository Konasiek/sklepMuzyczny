package com.sklepmuzyczny.demo.categories;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Category {


    @Id
    @GeneratedValue
    private Long CategoryId;
    private String nameCategory;
}
