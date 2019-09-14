package com.sklepmuzyczny.demo.controller;

import com.sklepmuzyczny.demo.DTO.UserDTO;
import com.sklepmuzyczny.demo.model.Customer;
import com.sklepmuzyczny.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController  {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getAllUsers () {
        List<Customer> list = userService.getUsers();
        return list;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getUserById(@PathVariable("id") Long id) {
        Customer customer = userService.getUserById(id);
        return customer;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer addUser(@RequestBody Customer customer) {
        userService.addNewUser(customer);

        return customer;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMessage(@PathVariable("id") long id) {
        userService.deleteById(id);
    }

    @PostMapping ("/newUser")
    public Customer addNewUser (@RequestBody UserDTO userDTO) {

        Customer customer = new Customer();
        customer.setPassword(userDTO.getPassword());
        customer.setLogin(userDTO.getLogin());
        customer.setUserId(userDTO.getUserId());

        userService.addNewUser(customer);
        return customer;

    }
}
