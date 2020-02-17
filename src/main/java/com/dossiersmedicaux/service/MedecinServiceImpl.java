package com.dossiersmedicaux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Medecin;
import com.dossiersmedicaux.repository.MedecinRepository;
import com.dossiersmedicaux.service.MedecinService;


@Service
public class MedecinServiceImpl implements MedecinService{



    @Autowired
    private MedecinRepository medecinRepository;

    @Override
    @Transactional
    public List < Medecin > getMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    @Transactional
    public void saveMedecin(Medecin themedecin) {
        medecinRepository.save(themedecin);
    }

    @Override
    @Transactional
    public Medecin getMedecin(int id) throws ResourceNotFoundException {
    	 return medecinRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteMedecin(int theId) {
        medecinRepository.deleteById(theId);
    }
    
   
}

