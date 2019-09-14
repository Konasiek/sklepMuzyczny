package com.sklepmuzyczny.demo.repository;

import com.sklepmuzyczny.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository <T extends Customer> extends CrudRepository<T, Long> {


}
