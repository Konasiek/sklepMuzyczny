package com.sklepmuzyczny.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class Category implements Serializable {


    @Id
    @GeneratedValue
    private Long categoryId;
    private String nameCategory;

//    @OneToMany
//    @Fetch(FetchMode.JOIN)
//    private List<Category> listOfCategories = new ArrayList<>();

    public Category() {
    }



    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }


}
