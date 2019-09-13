package com.sklepmuzyczny.demo.repository;

import com.sklepmuzyczny.demo.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {


}
