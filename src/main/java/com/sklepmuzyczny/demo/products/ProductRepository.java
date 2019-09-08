package com.sklepmuzyczny.demo.products;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Optional<Product> findByName(String product);
}
