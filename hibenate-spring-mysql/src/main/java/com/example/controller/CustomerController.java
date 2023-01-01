package com.example.controller;

import com.example.model.Customer;
import com.example.model.EntityCustomer;
import com.example.service.CustomerService;
import com.example.service.HibernateCustomerServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService = new HibernateCustomerServiceImp();
    @GetMapping("")
    private String showAll(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }
    @GetMapping("/create")
    private String createCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("/save")
    private String createCustomer(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }
}
