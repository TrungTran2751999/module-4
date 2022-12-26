package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
public class CustomerController {
    @GetMapping("/contructor")
    public String createContructor(){
        return "index";
    }
    @GetMapping("/")
    public String directShowAllCustomer(Model model){
        List<Customer> listCustomer = new ArrayList<>();
        if(!CustomerService.isContruct){
            CustomerService.listCustomer = new ArrayList<>();
            CustomerService.isContruct = true;
        }
        model.addAttribute("customers",listCustomer);
        return "index";
    }
    @GetMapping("/create-customer")
    public String directCreateCustomer(){
        return "create-customer";
    }
    @PostMapping("/create-customer")
    public String createCustomer(
            @RequestParam String name,
            @RequestParam String email,
            Model model
    ){
        CustomerService.listCustomer.add(new Customer(CustomerService.listCustomer.size()+1, name, email));
        model.addAttribute("customers",CustomerService.listCustomer);
        return "index";
    }
}
