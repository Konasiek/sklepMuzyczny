package com.sklepmuzyczny.demo.controller;

import com.sklepmuzyczny.demo.DTO.CustomerDTO;
import com.sklepmuzyczny.demo.model.Customer;
import com.sklepmuzyczny.demo.service.CustomerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getAllCustomer () {
        List<Customer> list = customerService.getCustomers();
        return list;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") Long id) {
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteById(id);
    }

    @PostMapping("/newCustomer")
    public Customer addCustomer(@RequestBody CustomerDTO customerDTO) {

        Customer customer = new Customer();
        customer.setPassword(customerDTO.getPassword());
        customer.setLogin(customerDTO.getLogin());
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setRoles(customerDTO.getRoles());

        customerService.addNewCustomer(customer);
        return customer;
    }
}
