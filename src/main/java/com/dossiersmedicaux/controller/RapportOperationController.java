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
import com.dossiersmedicaux.service.RapportOperationService;
import com.dossiersmedicaux.model.RapportOperation;




@Controller
@RequestMapping("/rapportOperation")
public class RapportOperationController {

    private static final Logger LOG = LoggerFactory.getLogger(RapportOperationController.class);

    @Autowired
    private RapportOperationService rapportOperationService;
    
   

    @GetMapping("/list")
    public String listRapportOperations(Model theModel) {
        List < RapportOperation > theOperations = rapportOperationService.getRapportOperations();
        theModel.addAttribute("rapportOperations", theOperations);
        return "list-rapportOperations";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show person-form handler method");
        RapportOperation theOperation = new RapportOperation();
        theModel.addAttribute("rapportOperation", theOperation);
        return "rapportOperation-form";
    }

    @PostMapping("/saveRapportOperation")
    public String saveRapportOperation(@ModelAttribute("rapportOperation") RapportOperation theOperation ) {
        rapportOperationService.saveRapportOperation(theOperation);
       
        return "redirect:/rapportOperation/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("rapportOperationId") int theId,
        Model theModel) throws ResourceNotFoundException {
        RapportOperation theOperation = rapportOperationService.getRapportOperation(theId);
        theModel.addAttribute("rapportOperation", theOperation);
        return "rapportOperation-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("rapportOperationId") int theId) throws ResourceNotFoundException {
        rapportOperationService.deleteRapportOperation(theId);
        return "redirect:/rapportOperation/list";
    }
    
  
}