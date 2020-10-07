package com.sklepmuzyczny.demo.service;

import com.sklepmuzyczny.demo.model.User;
import com.sklepmuzyczny.demo.model.Role;
import com.sklepmuzyczny.demo.repository.UserRepository;
import com.sklepmuzyczny.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers() {
        List<User> list = (List) userRepository.findAll();
        return list;
    }

    public User getUserById(Long id) {
        User user = (User) userRepository.findById(id).get();
        return user;
    }

    public void saveUser(User user) {
        user.setPassword(user.getPassword());
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        user.setActive(1);
        userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
