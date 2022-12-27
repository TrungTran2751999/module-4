package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class LoginController {
    private UserService userService = new UserService();
    @GetMapping("/")
    private String showForm(Model model){
        if(!UserService.init){
            UserService.init = true;
            UserService.listUser = new ArrayList<>();
        }
        model.addAttribute("user", new User());
        return "index";
    }
    @PostMapping("/login")
    private String createEmployee(@ModelAttribute ("user") User user, Model model){
        if(userService.login(user)!=null){
            model.addAttribute("user", user);
            return "view";
        }else{
            model.addAttribute("message","Log in failed !");
            return "index";
        }
    }
    @GetMapping("/register")
    private String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    private String register(@ModelAttribute("user") User user, Model model){
        if(userService.register(user)){
            user.setId((int) (Math.random()*1000+1000));
            userService.getListUser().add(user);
            model.addAttribute("user",user);
            return "view";
        }else{
            model.addAttribute("message","register failed. User exist");
            return "register";
        }
    }
    @GetMapping("/view")
    private String showView(){
        
    }
}
