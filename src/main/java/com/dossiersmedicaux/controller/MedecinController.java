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
import com.dossiersmedicaux.service.HopitalService;
import com.dossiersmedicaux.service.MedecinService;
import com.dossiersmedicaux.service.PersonneService;
import com.dossiersmedicaux.service.SpecialiteService;
import com.dossiersmedicaux.model.Hopital;
import com.dossiersmedicaux.model.Medecin;
import com.dossiersmedicaux.model.Personne;
import com.dossiersmedicaux.model.Specialite;




@Controller
@RequestMapping("/medecin")
public class MedecinController {

    private static final Logger LOG = LoggerFactory.getLogger(MedecinController.class);

    @Autowired
    private MedecinService medecinService;
    
    @Autowired
    private SpecialiteService specialiteService;
    
    @Autowired
    private PersonneService personneService;
    
    @Autowired
    private HopitalService hopitalService;

    @GetMapping("/list")
    public String listMedecins(Model theModel) {
        List < Medecin > theMeds = medecinService.getMedecins();
        theModel.addAttribute("medecins", theMeds);
        return "list-medecins";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show Medecin-form handler method");
        Medecin theMed = new Medecin();
        List <Specialite> specialite= specialiteService.getSpecialites();
        List <Hopital> hopital=hopitalService.getHopitals();
        theModel.addAttribute("specialites",specialite);
        theModel.addAttribute("medecin", theMed);
        theModel.addAttribute("hopitals",hopital);
        return "medecin-form";
    }

    @PostMapping("/saveMedecin")
    public String saveMedecin(@ModelAttribute("medecin") Medecin theMed ) {
      medecinService.saveMedecin(theMed);
       
        return "redirect:/medecin/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("medecinId") int theId,
        Model theModel) throws ResourceNotFoundException {
        Medecin theMed = medecinService.getMedecin(theId);
        theModel.addAttribute("medecin", theMed);
        return "medecin-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("medecinId") int theId) throws ResourceNotFoundException {
        medecinService.deleteMedecin(theId);
        return "redirect:/medecin/list";
    }
    
  
}