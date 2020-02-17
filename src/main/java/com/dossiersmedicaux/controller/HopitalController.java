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
import com.dossiersmedicaux.model.Hopital;
import com.dossiersmedicaux.service.HopitalService;




@Controller
@RequestMapping("/hopital")
public class HopitalController {

    private static final Logger LOG = LoggerFactory.getLogger(HopitalController.class);

    @Autowired
    private HopitalService hopitalService;
    
   

    @GetMapping("/list")
    public String listHopitals(Model theModel) {
        List < Hopital > theHopitals = hopitalService.getHopitals();
        theModel.addAttribute("hopitals", theHopitals);
        return "list-hopitals";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show person-form handler method");
        Hopital theHopital = new Hopital();
        theModel.addAttribute("hopital", theHopital);
        return "hopital-form";
    }

    @PostMapping("/saveHopital")
    public String saveHopital(@ModelAttribute("hopital") Hopital theHopital ) {
        hopitalService.saveHopital(theHopital);
       
        return "redirect:/hopital/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("hopitalId") int theId,
        Model theModel) throws ResourceNotFoundException {
        Hopital theHopital = hopitalService.getHopital(theId);
        theModel.addAttribute("hopital", theHopital);
        return "hopital-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("hopitalId") int theId) throws ResourceNotFoundException {
        hopitalService.deleteHopital(theId);
        return "redirect:/hopital/list";
    }
    
  
}