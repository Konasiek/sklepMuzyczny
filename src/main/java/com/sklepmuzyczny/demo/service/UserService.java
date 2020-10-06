package com.sklepmuzyczny.demo.service;

import com.sklepmuzyczny.demo.model.User;
import com.sklepmuzyczny.demo.model.Role;
import com.sklepmuzyczny.demo.repository.CustomerRepository;
import com.sklepmuzyczny.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class CustomerService {


    private CustomerRepository customerRepository;
    private RoleRepository roleRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           RoleRepository roleRepository
                           ) {

        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;

    }

    public void addNewCustomer(User customer) {
        customerRepository.save(customer);
    }

    public List<User> getCustomers() {
        List<User> list = (List) customerRepository.findAll();
        return list;
    }

    public User getCustomerById(Long id) {
        User customer = (User) customerRepository.findById(id).get();
        return customer;
    }

    public void saveCustomer(User customer){
        customer.setPassword(customer.getPassword());
        Role customerRole = roleRepository.findByRole("ADMIN");
        customer.setRoles(new HashSet<Role>(Arrays.asList(customerRole)));
        customer.setActive(1);
        customerRepository.save(customer);

    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
