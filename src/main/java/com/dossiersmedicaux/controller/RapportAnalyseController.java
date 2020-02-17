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
import com.dossiersmedicaux.service.RapportAnalyseService;
import com.dossiersmedicaux.model.RapportAnalyse;




@Controller
@RequestMapping("/rapportAnalyse")
public class RapportAnalyseController {

    private static final Logger LOG = LoggerFactory.getLogger(RapportAnalyseController.class);

    @Autowired
    private RapportAnalyseService rapportAnalyseService;
    
   

    @GetMapping("/list")
    public String listRapportAnalyses(Model theModel) {
        List < RapportAnalyse > theAnalyses = rapportAnalyseService.getRapportAnalyses();
        theModel.addAttribute("rapportAnalyses", theAnalyses);
        return "list-rapportAnalyses";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show person-form handler method");
        RapportAnalyse theAnalyse = new RapportAnalyse();
        theModel.addAttribute("rapportAnalyse", theAnalyse);
        return "rapportAnalyse-form";
    }

    @PostMapping("/saveRapportAnalyse")
    public String saveRapportAnalyse(@ModelAttribute("rapportAnalyse") RapportAnalyse theAnalyse ) {
        rapportAnalyseService.saveRapportAnalyse(theAnalyse);
       
        return "redirect:/rapportAnalyse/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("rapportAnalyseId") int theId,
        Model theModel) throws ResourceNotFoundException {
        RapportAnalyse theAnalyse = rapportAnalyseService.getRapportAnalyse(theId);
        theModel.addAttribute("rapportAnalyse", theAnalyse);
        return "rapportAnalyse-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("rapportAnalyseId") int theId) throws ResourceNotFoundException {
        rapportAnalyseService.deleteRapportAnalyse(theId);
        return "redirect:/rapportAnalyse/list";
    }
    
  
}