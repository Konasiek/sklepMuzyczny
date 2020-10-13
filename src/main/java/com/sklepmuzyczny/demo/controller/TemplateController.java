package com.sklepmuzyczny.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TemplateController {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String getLoginView() {
        return "login";
    }
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String getMainPage() {
        return "index";
    }
}