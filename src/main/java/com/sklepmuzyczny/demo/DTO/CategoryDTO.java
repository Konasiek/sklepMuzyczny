package com.sklepmuzyczny.demo.DTO;


public class CategoryDTO {

    private String nameCategory;

    public CategoryDTO() {
    }

    public CategoryDTO(String nameCategory) {

        this.nameCategory = nameCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
