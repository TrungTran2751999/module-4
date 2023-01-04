package com.example.controller;

import com.example.model.Customer;
import com.example.model.Province;
import com.example.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;
    @GetMapping("")
    private ModelAndView showAllProvince(){
        Iterable<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("index-province");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }
    @GetMapping("/create-province")
    private ModelAndView showCreateProvince(){
        ModelAndView modelAndView = new ModelAndView("create-province");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }
    @PostMapping("/create-province")
    private String createProvince(@ModelAttribute Province province){
        provinceService.save(province);
        return "redirect:/province";
    }
}
