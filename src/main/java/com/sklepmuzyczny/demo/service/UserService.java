package com.sklepmuzyczny.demo.service;

import com.sklepmuzyczny.demo.model.User;
import com.sklepmuzyczny.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService() {
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

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
