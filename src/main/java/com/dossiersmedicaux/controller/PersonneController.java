package com.dossiersmedicaux.controller;


	import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.service.PersonneService;
import com.dossiersmedicaux.model.Personne;




	@Controller
	@RequestMapping("/personne")
	public class PersonneController {

	    private static final Logger LOG = LoggerFactory.getLogger(PersonneController.class);

	    @Autowired
	    private PersonneService personneService;
	    
	    @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	    @InitBinder
	    public void initBinder(WebDataBinder binder) {

	       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	       dateFormat.setLenient(false);
	       binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }

	    @GetMapping("/list")
	    public String listPersonnes(Model theModel) {
	        List < Personne > thePersons = personneService.getPersonnes();
	        theModel.addAttribute("personnes", thePersons);
	        return "list-personnes";
	    }

	    @GetMapping("/showForm")
	    public String showFormForAdd(Model theModel) {
	        LOG.debug("inside show person-form handler method");
	        Personne thePerson = new Personne();
	        theModel.addAttribute("personne", thePerson);
	        return "personne-form";
	    }

	    @PostMapping("/savePersonne")
	    public String savePersonne(@ModelAttribute("personne") Personne thePerson,  BindingResult bindingResult ) throws ParseException {
	    	
	    	thePerson.setPassword(bCryptPasswordEncoder.encode(thePerson.getPassword()));
	    	personneService.savePersonne(thePerson);
	       
	        return "redirect:/personne/list";
	    }

	    @GetMapping("/updateForm")
	    public String showFormForUpdate(@RequestParam("personneId") int theId,
	        Model theModel) throws ResourceNotFoundException {
	        Personne thePerson = personneService.getPersonne(theId);
	        theModel.addAttribute("personne", thePerson);
	        return "personne-form";
	    }

	    @GetMapping("/delete")
	    public String deleteCustomer(@RequestParam("personneId") int theId) throws ResourceNotFoundException {
	        personneService.deletePersonne(theId);
	        return "redirect:/personne/list";
	    }
	    
	

	  
	  
	}
