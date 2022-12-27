package com.example.controller;

import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @GetMapping("/")
    private String showForm(Model model){
        model.addAttribute("employee", new Employee());
        return "index";
    }
    @PostMapping("/create")
    private String createEmployee(@ModelAttribute ("employee") Employee employee, Model model){
        model.addAttribute("employee", employee);
        return "view";
    }
}
