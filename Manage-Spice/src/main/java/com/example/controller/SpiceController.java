package com.example.controller;

import com.example.model.Spice;
import com.example.service.SpiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SpiceController {
    @GetMapping("/contructor")
    public String createContructor(){
        return "index";
    }
    @GetMapping("/")
    public String directShowAllSpice(Model model){
        List<Spice> listSpice = new ArrayList<>();
        if(!SpiceService.isContruct){
            SpiceService.listSpice = new ArrayList<>();
            SpiceService.isContruct = true;
        }
        model.addAttribute("customers", listSpice);
        return "index";
    }
    @GetMapping("/create-spice")
    public String directCreateSpice(){
        return "create-spice";
    }
    @PostMapping("/create-spice")
    public String createSpice(
            @RequestParam String name,
            @RequestParam String[] condiment,
            Model model
    ){
        SpiceService.listSpice.add(new Spice(SpiceService.listSpice.size()+1, name, condiment));
        model.addAttribute("customers", SpiceService.listSpice);
        return "index";
    }
}
