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
import com.dossiersmedicaux.service.PatientService;
import com.dossiersmedicaux.model.Patient;




@Controller
@RequestMapping("/patient")
public class PatientController {

    private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;
    
    @GetMapping("/list")
    public String listPatients(Model theModel) {
        List < Patient > thePatients = patientService.getPatients();
        theModel.addAttribute("patients", thePatients);
        return "list-patients";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show person-form handler method");
        Patient thePatient = new Patient();
        theModel.addAttribute("patient", thePatient);
        return "patient-form";
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute("patient") Patient thePatient ) {
    	
        patientService.savePatient(thePatient);
        
        return "redirect:/patient/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("patientId") int theId,
        Model theModel) throws ResourceNotFoundException {
        Patient thePatient = patientService.getPatient(theId);
        theModel.addAttribute("patient", thePatient);
        return "patient-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("patientId") int theId) throws ResourceNotFoundException {
        patientService.deletePatient(theId);
        return "redirect:/patient/list";
    }
    
  
}