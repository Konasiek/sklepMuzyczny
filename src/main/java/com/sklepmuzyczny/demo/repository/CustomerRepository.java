package com.sklepmuzyczny.demo.repository;

import com.sklepmuzyczny.demo.model.Customer;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByLogin(String login);

}
