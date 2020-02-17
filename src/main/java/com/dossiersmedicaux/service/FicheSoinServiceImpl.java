package com.dossiersmedicaux.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.FicheSoin;
import com.dossiersmedicaux.repository.FicheSoinRepository;
import com.dossiersmedicaux.service.FicheSoinService;


@Service
public class FicheSoinServiceImpl implements FicheSoinService{



    @Autowired
    private FicheSoinRepository ficheSoinRepository;

    @Override
    @Transactional
    public List < FicheSoin > getFicheSoins() {
        return ficheSoinRepository.findAll();
    }

    @Override
    @Transactional
    public void saveFicheSoin(FicheSoin theficheSoin) {
        ficheSoinRepository.save(theficheSoin);
    }

    @Override
    @Transactional
    public FicheSoin getFicheSoin(int id) throws ResourceNotFoundException {
    	 return ficheSoinRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteFicheSoin(int theId) {
        ficheSoinRepository.deleteById(theId);
    }
    
   
}

