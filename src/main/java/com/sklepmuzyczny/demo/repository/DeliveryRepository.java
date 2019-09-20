package com.sklepmuzyczny.demo.repository;

import com.sklepmuzyczny.demo.model.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends CrudRepository <Delivery, Long> {
}
