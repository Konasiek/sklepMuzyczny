package com.sklepmuzyczny.demo.model;

import lombok.Getter;
import lombok.Setter;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
//@Entity
public class Category implements Serializable {


//    @Id
//    @GeneratedValue
    private Long CategoryId;
    private String nameCategory;
}
