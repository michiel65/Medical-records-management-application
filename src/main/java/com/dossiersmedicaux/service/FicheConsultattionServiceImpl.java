package com.dossiersmedicaux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.FicheConsultattion;
import com.dossiersmedicaux.repository.FicheConsultattionRepository;
import com.dossiersmedicaux.service.FicheConsultattionService;


@Service
public class FicheConsultattionServiceImpl implements FicheConsultattionService{



    @Autowired
    private FicheConsultattionRepository ficheConsultattionRepository;

    @Override
    @Transactional
    public List < FicheConsultattion > getFicheConsultattions() {
        return ficheConsultattionRepository.findAll();
    }

    @Override
    @Transactional
    public void saveFicheConsultattion(FicheConsultattion theficheConsult) {
        ficheConsultattionRepository.save(theficheConsult);
    }

    @Override
    @Transactional
    public FicheConsultattion getFicheConsultattion(int id) throws ResourceNotFoundException {
    	 return ficheConsultattionRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteFicheConsultattion(int theId) {
        ficheConsultattionRepository.deleteById(theId);
    }
   
    }


