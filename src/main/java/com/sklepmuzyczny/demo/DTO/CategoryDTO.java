package com.sklepmuzyczny.demo.DTO;


public class CategoryDTO {


    private Long CategoryId;
    private String nameCategory;


    public CategoryDTO() {
    }

    public CategoryDTO(Long categoryId, String nameCategory) {
        CategoryId = categoryId;
        this.nameCategory = nameCategory;

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

}
