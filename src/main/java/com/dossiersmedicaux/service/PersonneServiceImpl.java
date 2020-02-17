package com.dossiersmedicaux.service;




	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

	import com.dossiersmedicaux.exception.ResourceNotFoundException;
	import com.dossiersmedicaux.model.Personne;
	import com.dossiersmedicaux.repository.PersonneRepository;
	import com.dossiersmedicaux.service.PersonneService;


	@Service
	public class PersonneServiceImpl implements PersonneService{

	

	    @Autowired
	    private PersonneRepository personneRepository;

	    @Override
	    @Transactional
	    public List < Personne > getPersonnes() {
	        return personneRepository.findAll();
	    }

	    @Override
	    @Transactional
	    public void savePersonne(Personne theperson) {
	        personneRepository.save(theperson);
	    }

	    @Override
	    @Transactional
	    public Personne getPersonne(int id) throws ResourceNotFoundException {
	    	 return personneRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
	    }

	    @Override
	    @Transactional
	    public void deletePersonne(int theId) {
	        personneRepository.deleteById(theId);
	    }
	    
	    @Override
		@Transactional(readOnly = true)
		public Personne findByLogin(String login) {
			Personne person = null;
			try {
				person = personneRepository.findByLogin(login);
			} catch (Exception e) {
				throw e;
			}
			return person;
		}
	}
	
