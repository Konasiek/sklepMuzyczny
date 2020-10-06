package com.sklepmuzyczny.demo.repository;

import com.sklepmuzyczny.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<User, Long> {
    //User findByLogin(String login);

}
