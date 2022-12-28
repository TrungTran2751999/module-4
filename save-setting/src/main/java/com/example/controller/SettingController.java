package com.example.controller;

import com.example.model.Setting;
import com.example.service.SettingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
    private SettingService settingService = new SettingService();
    @GetMapping("")
    private String loadInit(Model model){
        if(!SettingService.init){
            SettingService.init = true;
            SettingService.initSetting = new Setting("Tieng ziet", 25, false, "Trung");
        }
        Setting setting = settingService.loadInit();
        model.addAttribute("setting",setting);
        return "index";
    }
    @PostMapping("/save")
    private ModelAndView saveSetting(@ModelAttribute("setting") Setting setting){
        settingService.saveSetting(setting);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("setting",setting);
        return modelAndView;
    }
}
