package com.example.controller;

import com.example.model.Address;
import com.example.model.Exposure;
import com.example.model.FormNCoV;
import com.example.model.Symtom;
import com.example.service.FormNCoVService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FormNCoVController {
    private FormNCoVService formNCoVService = new FormNCoVService();
    @GetMapping("")
    private String directIndex(Model model){
        FormNCoV newForm = new FormNCoV();
        if(!FormNCoVService.init){
            FormNCoVService.formNCoV = new FormNCoV();
            FormNCoVService.formNCoV.setAddress(new Address("","","","","",""));

            FormNCoVService.formNCoV.setSymtom(new Symtom("","","","","","","",""));
            FormNCoVService.formNCoV.setExposure(new Exposure("",""));
            formNCoVService.insertDate();
        }
        model.addAttribute("formNCoV", FormNCoVService.formNCoV);

        model.addAttribute("dates", FormNCoVService.date);

        model.addAttribute("months",FormNCoVService.month);

        model.addAttribute("years",FormNCoVService.year);

        model.addAttribute("vehicles", FormNCoVService.vehicle);
        model.addAttribute("provinces", FormNCoVService.province);
        model.addAttribute("districts", FormNCoVService.district);
        model.addAttribute("guilds", FormNCoVService.guild);
        model.addAttribute("yesNos", FormNCoVService.yesNo);

        return "form-NcoV";
    }
    @PostMapping("/save")
    private String save(@ModelAttribute FormNCoV formNCoV){
        FormNCoVService.init = true;
        formNCoVService.createAndUpdateForm(formNCoV);
        return "save";
    }
}
