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
import com.dossiersmedicaux.service.FicheConsultattionService;
import com.dossiersmedicaux.model.FicheConsultattion;




@Controller
@RequestMapping("/ficheConsultattion")
public class FicheConsultattionController {

    private static final Logger LOG = LoggerFactory.getLogger(FicheConsultattionController.class);

    @Autowired
    private FicheConsultattionService ficheConsultattionService;
    
   

    @GetMapping("/list")
    public String listFicheConsultattions(Model theModel) {
        List < FicheConsultattion > theFicheConsults = ficheConsultattionService.getFicheConsultattions();
        theModel.addAttribute("ficheConsultattions", theFicheConsults);
        return "list-ficheConsultattions";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show person-form handler method");
        FicheConsultattion theFicheConsult = new FicheConsultattion();
        theModel.addAttribute("ficheConsultattion", theFicheConsult);
        return "ficheConsultattion-form";
    }

    @PostMapping("/saveFicheConsultattion")
    public String saveFicheConsultattion(@ModelAttribute("ficheConsultattion") FicheConsultattion theFicheConsult ) {
        ficheConsultattionService.saveFicheConsultattion(theFicheConsult);
       
        return "redirect:/ficheConsultattion/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("ficheConsultattionId") int theId,
        Model theModel) throws ResourceNotFoundException {
        FicheConsultattion theFicheConsult = ficheConsultattionService.getFicheConsultattion(theId);
        theModel.addAttribute("ficheConsultattion", theFicheConsult);
        return "ficheConsultattion-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("ficheConsultattionId") int theId) throws ResourceNotFoundException {
        ficheConsultattionService.deleteFicheConsultattion(theId);
        return "redirect:/ficheConsultattion/list";
    }
    
  
}