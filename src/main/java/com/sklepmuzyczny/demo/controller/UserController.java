package com.sklepmuzyczny.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class UserController  {

    @RequestMapping({"/users/","/users","/user", "/users/index.html" })
    public String index(){
        return "userIndex";
    }
}
