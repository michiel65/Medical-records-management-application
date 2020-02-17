package com.dossiersmedicaux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.FicheInfirmiere;
import com.dossiersmedicaux.repository.FicheInfirmiereRepository;
import com.dossiersmedicaux.service.FicheInfirmiereService;


@Service
public class FicheInfirmiereServiceImpl implements FicheInfirmiereService{



    @Autowired
    private FicheInfirmiereRepository ficheInfirmiereRepository;

    @Override
    @Transactional
    public List < FicheInfirmiere > getFicheInfirmieres() {
        return ficheInfirmiereRepository.findAll();
    }

    @Override
    @Transactional
    public void saveFicheInfirmiere(FicheInfirmiere theficheInfirmiere) {
        ficheInfirmiereRepository.save(theficheInfirmiere);
    }

    @Override
    @Transactional
    public FicheInfirmiere getFicheInfirmiere(int id) throws ResourceNotFoundException {
    	 return ficheInfirmiereRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteFicheInfirmiere(int theId) {
        ficheInfirmiereRepository.deleteById(theId);
    }
    
   

}

