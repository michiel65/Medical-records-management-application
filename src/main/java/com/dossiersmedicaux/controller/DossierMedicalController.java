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
import com.dossiersmedicaux.service.DossierMedicalService;
import com.dossiersmedicaux.model.DossierMedical;




@Controller
@RequestMapping("/dossierMedical")
public class DossierMedicalController {

    private static final Logger LOG = LoggerFactory.getLogger(DossierMedicalController.class);

    @Autowired
    private DossierMedicalService dossierMedicalService;
    
   

    @GetMapping("/list")
    public String listDossierMedicals(Model theModel) {
        List < DossierMedical > theDossiers = dossierMedicalService.getDossierMedicals();
        theModel.addAttribute("dossierMedicals", theDossiers);
        return "list-dossierMedicals";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show person-form handler method");
        DossierMedical theDossier = new DossierMedical();
        theModel.addAttribute("dossierMedical", theDossier);
        return "dossierMedical-form";
    }

    @PostMapping("/saveDossierMedical")
    public String saveDossierMedical(@ModelAttribute("dossierMedical") DossierMedical theDossier ) {
        dossierMedicalService.saveDossierMedical(theDossier);
       
        return "redirect:/dossierMedical/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("dossierMedicalId") int theId,
        Model theModel) throws ResourceNotFoundException {
        DossierMedical theDossier = dossierMedicalService.getDossierMedical(theId);
        theModel.addAttribute("dossierMedical", theDossier);
        return "dossierMedical-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("dossierMedicalId") int theId) throws ResourceNotFoundException {
        dossierMedicalService.deleteDossierMedical(theId);
        return "redirect:/dossierMedical/list";
    }
    
  
}
