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
import com.dossiersmedicaux.service.PrescriptionService;
import com.dossiersmedicaux.model.Prescription;




@Controller
@RequestMapping("/prescription")
public class PrescriptionController {

    private static final Logger LOG = LoggerFactory.getLogger(PrescriptionController.class);

    @Autowired
    private PrescriptionService prescriptionService;
    
   

    @GetMapping("/list")
    public String listPrescriptions(Model theModel) {
        List < Prescription > thePrescripts = prescriptionService.getPrescriptions();
        theModel.addAttribute("prescriptions", thePrescripts);
        return "list-prescriptions";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show person-form handler method");
        Prescription thePrescript = new Prescription();
        theModel.addAttribute("prescription", thePrescript);
        return "prescription-form";
    }

    @PostMapping("/savePrescription")
    public String savePrescription(@ModelAttribute("prescription") Prescription thePrescript ) {
        prescriptionService.savePrescription(thePrescript);
       
        return "redirect:/prescription/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("prescriptionId") int theId,
        Model theModel) throws ResourceNotFoundException {
        Prescription thePrescript = prescriptionService.getPrescription(theId);
        theModel.addAttribute("prescription", thePrescript);
        return "prescription-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("prescriptionId") int theId) throws ResourceNotFoundException {
        prescriptionService.deletePrescription(theId);
        return "redirect:/prescription/list";
    }
    
  
}