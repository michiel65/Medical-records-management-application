package com.dossiersmedicaux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.RapportAnalyse;
import com.dossiersmedicaux.repository.RapportAnalyseRepository;
import com.dossiersmedicaux.service.RapportAnalyseService;


@Service
public class RapportAnalyseServiceImpl implements RapportAnalyseService{



    @Autowired
    private RapportAnalyseRepository rapportAnalyseRepository;

    @Override
    @Transactional
    public List < RapportAnalyse > getRapportAnalyses() {
        return rapportAnalyseRepository.findAll();
    }

    @Override
    @Transactional
    public void saveRapportAnalyse(RapportAnalyse therapportAnalyse) {
        rapportAnalyseRepository.save(therapportAnalyse);
    }

    @Override
    @Transactional
    public RapportAnalyse getRapportAnalyse(int id) throws ResourceNotFoundException {
    	 return rapportAnalyseRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteRapportAnalyse(int theId) {
        rapportAnalyseRepository.deleteById(theId);
    }
    
  
}

