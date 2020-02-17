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
import com.dossiersmedicaux.service.FicheInfirmiereService;
import com.dossiersmedicaux.model.FicheInfirmiere;




@Controller
@RequestMapping("/ficheInfirmiere")
public class FicheInfirmiereController {

    private static final Logger LOG = LoggerFactory.getLogger(FicheInfirmiereController.class);

    @Autowired
    private FicheInfirmiereService ficheInfirmiereService;
    
   

    @GetMapping("/list")
    public String listFicheInfirmieres(Model theModel) {
        List < FicheInfirmiere > theFicheInfirms = ficheInfirmiereService.getFicheInfirmieres();
        theModel.addAttribute("ficheInfirmieres", theFicheInfirms);
        return "list-ficheInfirmieres";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show person-form handler method");
        FicheInfirmiere theFicheInfirm = new FicheInfirmiere();
        theModel.addAttribute("ficheInfirmiere", theFicheInfirm);
        return "ficheInfirmiere-form";
    }

    @PostMapping("/saveFicheInfirmiere")
    public String saveFicheInfirmiere(@ModelAttribute("ficheInfirmiere") FicheInfirmiere theFicheInfirm ) {
        ficheInfirmiereService.saveFicheInfirmiere(theFicheInfirm);
       
        return "redirect:/ficheInfirmiere/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("ficheInfirmiereId") int theId,
        Model theModel) throws ResourceNotFoundException {
        FicheInfirmiere theFicheInfirm = ficheInfirmiereService.getFicheInfirmiere(theId);
        theModel.addAttribute("ficheInfirmiere", theFicheInfirm);
        return "ficheInfirmiere-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("ficheInfirmiereId") int theId) throws ResourceNotFoundException {
        ficheInfirmiereService.deleteFicheInfirmiere(theId);
        return "redirect:/ficheInfirmiere/list";
    }
    
  
}