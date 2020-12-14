package com.sklepmuzyczny.demo.repository;

import com.sklepmuzyczny.demo.model.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Zhu Lin on 3/14/2018.
 */
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

}
