package com.sklepmuzyczny.demo.controller;

import com.sklepmuzyczny.demo.DTO.UserDTO;
import com.sklepmuzyczny.demo.model.User;
import com.sklepmuzyczny.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUser () {
        List<User> list = userService.getUsers();
        return list;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody UserDTO userDTO) {

        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setLogin(userDTO.getLogin());
        user.setUserId(userDTO.getUserId());

        userService.addNewUser(user);
        return user;
    }
}
