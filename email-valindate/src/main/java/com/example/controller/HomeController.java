package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    private static final String regexString = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private Pattern pattern;
    private Matcher matcher;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @PostMapping(value = "/validate")
    public String user(@RequestParam("email") String email, Model model){
        boolean isValid = valindate(email);
        if(!isValid){
            model.addAttribute("email", "email not valid");
            return "home";
        }
        model.addAttribute("email",email);
        return "success";
    }
    public boolean valindate(String regex){
        pattern = Pattern.compile(regexString);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
