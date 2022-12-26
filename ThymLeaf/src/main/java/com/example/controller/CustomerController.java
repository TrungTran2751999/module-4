package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Controller
public class CustomerController {
    private ICustomerService customerService = new CustomerService();
    @GetMapping("/")
    private String showAllCustomer(Model model){
        if(!CustomerService.init){
            CustomerService.init = true;
            CustomerService.listCustomer = new HashMap<>();
            customerService.save(new Customer(1, "Trung", "trung@gmail.com"));
            customerService.save(new Customer(2, "Trung", "trung@gmail.com"));
            customerService.save(new Customer(3, "Trung", "trung@gmail.com"));
        }
        model.addAttribute("list",customerService.findAll());
        return "index";
    }
    @GetMapping("/create")
    private String createCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }
    @PostMapping("/save")
    private String save(Customer customer){
        customer.setId((int) (Math.random()*1000+1000));
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    private String edit(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    private String edit(Customer customer){
        customerService.update(customer.getId(), customer);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    private String delete(@PathVariable int id){
        customerService.remove(id);
        return "redirect:/";
    }
}
