package com.sklepmuzyczny.demo.repository;

import com.sklepmuzyczny.demo.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository<T extends User> extends CrudRepository<T, Long> {



}
