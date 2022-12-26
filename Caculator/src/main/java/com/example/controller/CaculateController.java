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
public class CaculateController {
//    @GetMapping("/contructor")
//    public String createContructor(){
//        return "index";
//    }
    @GetMapping("/")
    public String directShowAllSpice(Model model){
//        List<Spice> listSpice = new ArrayList<>();
//        if(!SpiceService.isContruct){
//            SpiceService.listSpice = new ArrayList<>();
//            SpiceService.isContruct = true;
//        }
//        model.addAttribute("customers", listSpice);

        return "index";
    }
//    @GetMapping("/create-spice")
//    public String directCreateSpice(){
//        return "create-spice";
//    }
    @PostMapping("/caculate")
    public String createSpice(
            @RequestParam String action,
            @RequestParam String var1,
            @RequestParam String var2,
            Model model
    ) {
//        SpiceService.listSpice.add(new Spice(SpiceService.listSpice.size()+1, name, condiment));
//        model.addAttribute("customers", SpiceService.listSpice);
        try {
            double intVar1 = Double.parseDouble(var1);
            double intVar2 = Double.parseDouble(var2);
            double result = 0;
            switch (action) {
                case "add":
                    result = intVar1 + intVar2;
                    break;
                case "sub":
                    result = intVar1 - intVar2;
                    break;
                case "multi":
                    result = intVar1 * intVar2;
                    break;
                case "division":
                    result = intVar1 / intVar2;
                    break;
                default:
                    return "404";
            }
            model.addAttribute("action", action);
            model.addAttribute("var1", intVar1);
            model.addAttribute("var2", intVar2);
            model.addAttribute("result", result);
            return "result";
        } catch (Exception e) {
            return "404";
        }
    }
}
