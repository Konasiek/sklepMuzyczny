package com.sklepmuzyczny.demo.controller;

import com.sklepmuzyczny.demo.DTO.CategoryDTO;
import com.sklepmuzyczny.demo.model.Category;
import com.sklepmuzyczny.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        List<Category> list = categoryService.getCategories();
        return list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable("id") Long id) {
        Category category = categoryService.getCategoryById(id);
        return category;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category) {
        categoryService.addNewCategory(category);

        return category;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable("id") long id) {
        categoryService.deleteById(id);
    }

    @PostMapping("/newCategory")
    public Category addCategory(@RequestBody CategoryDTO categoryDTO) {

        Category category = new Category();
        category.setNameCategory(categoryDTO.getNameCategory());
        category.setCategoryId(categoryDTO.getCategoryId());

        categoryService.addNewCategory(category);
        return category;

    }


}
