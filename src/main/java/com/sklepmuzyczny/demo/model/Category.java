package com.sklepmuzyczny.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Category implements Serializable {


    @Id
    @GeneratedValue
    private Long CategoryId;
    private String nameCategory;

    @OneToMany
    private List<Product> listOfProducts = new ArrayList<>();


    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
}
