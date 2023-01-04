package com.example.controller;

import com.example.model.Customer;
import com.example.model.Province;
import com.example.repository.IProvinceRepository;
import com.example.service.ICustomerService;
import com.example.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProvinceService provinceService;
    @GetMapping("/create-customer")
    private ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @PostMapping("/create-customer")
    private String createForm(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("")
    private ModelAndView showAllCustomer(){
        List<Customer> customer = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customers",customer);
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    private String deleteCustomer(@PathVariable long id){
        customerService.remove(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/update")
    private ModelAndView showEditForm(@PathVariable long id){
        Optional<Customer> customer = customerService.findById(id);
        ModelAndView modelAndView = null;
        if(customer.isPresent()){
            modelAndView = new ModelAndView("edit");
            modelAndView.addObject("customer",customer);
        }else{
            modelAndView = new ModelAndView("404");
        }
        return modelAndView;
    }
    @PostMapping("/edit")
    private String editForm(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }
    @ModelAttribute("provinces")
    private List<Province> findAllProvince(){
        return provinceService.findAll();
    }
}
