package com.sklepmuzyczny.demo.users;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepository<T extends User> extends CrudRepository<T, Long> {

    Optional<T> findByUsername(String userName);

    boolean existsByUsername(String username);

}
