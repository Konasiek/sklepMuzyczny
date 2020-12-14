package com.sklepmuzyczny.demo.repository;

import com.sklepmuzyczny.demo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
