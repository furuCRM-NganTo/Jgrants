package com.furucrm.jgrants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.furucrm.dto.SubsidyDTO;
import com.furucrm.jgrants.entiy.Subsidy;
import com.furucrm.jgrants.service.SubsidyService;

@Controller
@RequestMapping
public class SubsidyController {

    @Autowired
    private SubsidyService subsidyService;
       
    @GetMapping("/list")
    public String listAll(Model model) {
        List<Subsidy> subsidies = subsidyService.getAllSubsidy();
        model.addAttribute("subsidies",subsidies);
        System.out.println(subsidies);
        return "page/list";
        //return subsidyService.getAllSubsidy();
    }

    @GetMapping("/detail/{subsidyId}")
    public String getDetailSubsidy(@PathVariable Long subsidyId,Model model){
        System.out.println(subsidyId);
        SubsidyDTO subsidy = subsidyService.getSubsidyById(subsidyId);
        model.addAttribute("subsidy", subsidy);
        return "page/detail";
    }

    @GetMapping("/create")
    public String showFrom(){
        Subsidy subsidy = new Subsidy();
        System.out.println(subsidy.getOpenDataAgreement());
        return "page/create";
    }

    @PutMapping("/save")
    public String updateSubsidy(@PathVariable Long subsidyId, @RequestBody Subsidy subsidy){
        return subsidyService.updateSubsidy(subsidyId, subsidy);
    }

    @GetMapping("/save")
    public String saveSubsidies(Model model) {
        List<Subsidy> subsidies = subsidyService.saveSubsidy();
        model.addAttribute("subsidies", subsidies);
        return "page/list";
    }

    @DeleteMapping("/delete/{subsidyId}")
    public List<Subsidy> deleteSubsidies(@PathVariable Long subsidyId) {
        return subsidyService.deleteSubsidy(subsidyId);
    }
    
}
