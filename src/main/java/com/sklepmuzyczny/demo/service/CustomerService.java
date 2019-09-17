package com.sklepmuzyczny.demo.service;

import com.sklepmuzyczny.demo.model.Customer;
import com.sklepmuzyczny.demo.model.Role;
import com.sklepmuzyczny.demo.repository.CustomerRepository;
import com.sklepmuzyczny.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void addNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        List<Customer> list = (List) customerRepository.findAll();
        return list;
    }

    public Customer getCustomerById(Long id) {
        Customer customer = (Customer) customerRepository.findById(id).get();
        return customer;
    }

    public void saveCustomer(Customer customer){
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        Role customerRole = roleRepository.findByRole("ADMIN");
        customer.setRoles(new HashSet<Role>(Arrays.asList(customerRole)));
        customer.setActive(1);
        customerRepository.save(customer);

    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
