package com.sklepmuzyczny.demo.service;

import com.sklepmuzyczny.demo.model.Customer;
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

    public void addNewUser(Customer customer) {
        userRepository.save(customer);
    }

    public List<Customer> getUsers() {
        List<Customer> list = (List) userRepository.findAll();
        return list;
    }

    public Customer getUserById(Long id) {
        Customer customer = (Customer) userRepository.findById(id).get();
        return customer;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
