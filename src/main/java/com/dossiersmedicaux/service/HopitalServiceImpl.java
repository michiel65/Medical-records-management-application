package com.dossiersmedicaux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Hopital;
import com.dossiersmedicaux.repository.HopitalRepository;
import com.dossiersmedicaux.service.HopitalService;


@Service
public class HopitalServiceImpl implements HopitalService{



    @Autowired
    private HopitalRepository hopitalRepository;

    @Override
    @Transactional
    public List < Hopital > getHopitals() {
        return hopitalRepository.findAll();
    }

    @Override
    @Transactional
    public void saveHopital(Hopital thehopital) {
        hopitalRepository.save(thehopital);
    }

    @Override
    @Transactional
    public Hopital getHopital(int id) throws ResourceNotFoundException {
    	 return hopitalRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteHopital(int theId) {
        hopitalRepository.deleteById(theId);
    }
    
    
}

