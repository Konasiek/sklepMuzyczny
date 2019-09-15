package com.sklepmuzyczny.demo.service;

import com.sklepmuzyczny.demo.model.Product;
import com.sklepmuzyczny.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService() {
    }

    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProducts() {
        List<Product> list = (List) productRepository.findAll();
        return list;
    }
    public Product getProductById(Long id) {
        Product product = (Product) productRepository.findById(id).get();
        return product;
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


}
