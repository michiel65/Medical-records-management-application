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

import com.dossiersmedicaux.service.ConsultationService;
import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Consultation;




@Controller
@RequestMapping("/consultation")
public class ConsultationController {

    private static final Logger LOG = LoggerFactory.getLogger(ConsultationController.class);

    @Autowired
    private ConsultationService consultationService;
    
   

    @GetMapping("/list")
    public String listConsultations(Model theModel) {
        List < Consultation > theConsults = consultationService.getConsultations();
        theModel.addAttribute("consultations", theConsults);
        return "list-consultations";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show consultation-form handler method");
        Consultation theConsult = new Consultation();
        theModel.addAttribute("consultation", theConsult);
        return "consultation-form";
    }

    @PostMapping("/saveConsultation")
    public String saveConsultation(@ModelAttribute("consultation") Consultation theConsult ) {
        consultationService.saveConsultation(theConsult);
       
        return "redirect:/consultation/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("consultationId") int theId,
        Model theModel) throws ResourceNotFoundException {
        Consultation theConsult = consultationService.getConsultation(theId);
        theModel.addAttribute("consultation", theConsult);
        return "consultation-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("consultationId") int theId) throws ResourceNotFoundException {
        consultationService.deleteConsultation(theId);
        return "redirect:/consultation/list";
    }
    
  
}