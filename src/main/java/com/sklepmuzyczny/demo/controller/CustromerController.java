package com.sklepmuzyczny.demo.controller;

import com.sklepmuzyczny.demo.DTO.CustomerDTO;
import com.sklepmuzyczny.demo.model.Customer;
import com.sklepmuzyczny.demo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustromerController {

    CustomerService customerService;

    public CustromerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getAllCustomer () {
        List<Customer> list = customerService.getUsers();
        return list;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") Long id) {
        Customer customer = customerService.getUserById(id);
        return customer;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer) {
        customerService.addNewUser(customer);

        return customer;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteById(id);
    }

    @PostMapping ("/newCustomer")
    public Customer addCustomerUser (@RequestBody CustomerDTO customerDTO) {

        Customer customer = new Customer();
        customer.setPassword(customerDTO.getPassword());
        customer.setLogin(customerDTO.getLogin());
        customer.setCustomerId(customerDTO.getCustomerId());

        customerService.addNewUser(customer);
        return customer;

    }
}
