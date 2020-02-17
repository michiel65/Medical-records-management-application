package com.dossiersmedicaux.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.service.SpecialiteService;
import com.dossiersmedicaux.model.Specialite;




@Controller
@RequestMapping("/specialite")
public class SpecialiteController {

    private static final Logger LOG = LoggerFactory.getLogger(SpecialiteController.class);

    @Autowired
    private SpecialiteService specialiteService;
    
   

    @GetMapping("/list")
    public String listSpecialites(Model theModel) {
        List < Specialite > theSpecials = specialiteService.getSpecialites();
        theModel.addAttribute("specialites", theSpecials);
        return "list-specialites";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show person-form handler method");
        Specialite theSpecial = new Specialite();
        theModel.addAttribute("specialite", theSpecial);
        return "specialite-form";
    }

    @PostMapping("/saveSpecialite")
    public String saveSpecialite(@ModelAttribute("specialite") Specialite theSpecial ) {
        specialiteService.saveSpecialite(theSpecial);
       
        return "redirect:/specialite/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("specialiteId") int theId,
        Model theModel) throws ResourceNotFoundException {
        Specialite theSpecial = specialiteService.getSpecialite(theId);
        theModel.addAttribute("specialite", theSpecial);
        return "specialite-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("specialiteId") int theId) throws ResourceNotFoundException {
        specialiteService.deleteSpecialite(theId);
        return "redirect:/specialite/list";
    }
    
  
}