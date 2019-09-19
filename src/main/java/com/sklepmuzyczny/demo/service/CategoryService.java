package com.sklepmuzyczny.demo.service;

import com.sklepmuzyczny.demo.model.Category;
import com.sklepmuzyczny.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public CategoryService() {
    }

    public void addNewCategory(Category category) {
        categoryRepository.save(category);

    }

    public List<Category> getAllCategories() {
        List<Category> list = (List<Category>) categoryRepository.findAll();
        return list;
    }
    public Category getCategoryById(Long id) {
        Category category = (Category) categoryRepository.findById(id).get();
        return category;
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

}
