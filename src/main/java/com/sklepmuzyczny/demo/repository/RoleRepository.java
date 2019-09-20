package com.sklepmuzyczny.demo.repository;


import com.sklepmuzyczny.demo.model.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
