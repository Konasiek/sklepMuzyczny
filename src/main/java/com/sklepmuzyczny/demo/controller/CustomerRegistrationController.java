package com.sklepmuzyczny.demo.controller;

import com.sklepmuzyczny.demo.model.Customer;
import com.sklepmuzyczny.demo.service.CustomerService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class CustomerRegistrationController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showRegistrationForm(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customer", new Customer());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView createNewCustomer(@Valid Customer customer, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            customerService.saveCustomer(customer);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("customer", new Customer());
            modelAndView.setViewName("registration");
            modelAndView.addObject("successMessage", "Customer has been registered successfully");
        }
        return modelAndView;
    }

}
