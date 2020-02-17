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
import com.dossiersmedicaux.service.FicheSoinService;
import com.dossiersmedicaux.model.FicheSoin;




@Controller
@RequestMapping("/ficheSoin")
public class FicheSoinController {

    private static final Logger LOG = LoggerFactory.getLogger(FicheSoinController.class);

    @Autowired
    private FicheSoinService ficheSoinService;
    
   

    @GetMapping("/list")
    public String listFicheSoins(Model theModel) {
        List < FicheSoin > theFicheSoins = ficheSoinService.getFicheSoins();
        theModel.addAttribute("ficheSoins", theFicheSoins);
        return "list-ficheSoins";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show person-form handler method");
        FicheSoin theFicheSoin = new FicheSoin();
        theModel.addAttribute("ficheSoin", theFicheSoin);
        return "ficheSoin-form";
    }

    @PostMapping("/saveFicheSoin")
    public String saveFicheSoin(@ModelAttribute("ficheSoin") FicheSoin theFicheSoin ) {
        ficheSoinService.saveFicheSoin(theFicheSoin);
       
        return "redirect:/ficheSoin/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("ficheSoinId") int theId,
        Model theModel) throws ResourceNotFoundException {
        FicheSoin theFicheSoin = ficheSoinService.getFicheSoin(theId);
        theModel.addAttribute("ficheSoin", theFicheSoin);
        return "ficheSoin-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("ficheSoinId") int theId) throws ResourceNotFoundException {
        ficheSoinService.deleteFicheSoin(theId);
        return "redirect:/ficheSoin/list";
    }
    
  
}