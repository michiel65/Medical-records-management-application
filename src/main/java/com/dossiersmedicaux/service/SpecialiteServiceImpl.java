package com.dossiersmedicaux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Specialite;
import com.dossiersmedicaux.repository.SpecialiteRepository;
import com.dossiersmedicaux.service.SpecialiteService;


@Service
public class SpecialiteServiceImpl implements SpecialiteService{



    @Autowired
    private SpecialiteRepository specialiteRepository;

    @Override
    @Transactional
    public List < Specialite > getSpecialites() {
        return specialiteRepository.findAll();
    }

    @Override
    @Transactional
    public void saveSpecialite(Specialite thespecialite) {
        specialiteRepository.save(thespecialite);
    }

    @Override
    @Transactional
    public Specialite getSpecialite(int id) throws ResourceNotFoundException {
    	 return specialiteRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteSpecialite(int theId) {
        specialiteRepository.deleteById(theId);
    }
    
  
}

