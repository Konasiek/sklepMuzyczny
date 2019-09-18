package com.sklepmuzyczny.demo.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @Fetch(FetchMode.JOIN)
    private List<Category> listOfCategories = new ArrayList<>();

    public Category() {
    }

    public Category(String nameCategory, List<Category> listOfCategories) {
        this.nameCategory = nameCategory;
        this.listOfCategories = listOfCategories;
    }

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

    public List<Category> getListOfCategories() {
        return listOfCategories;
    }

    public void setListOfCategories(List<Category> listOfCategories) {
        this.listOfCategories = listOfCategories;
    }
}
