package com.sklepmuzyczny.demo.service;

import com.sklepmuzyczny.demo.model.Customer;
import com.sklepmuzyczny.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerService() {
    }

    public void addNewUser(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getUsers() {
        List<Customer> list = (List) customerRepository.findAll();
        return list;
    }

    public Customer getUserById(Long id) {
        Customer customer = (Customer) customerRepository.findById(id).get();
        return customer;
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
