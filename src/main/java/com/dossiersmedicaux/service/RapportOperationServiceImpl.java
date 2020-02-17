package com.dossiersmedicaux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.RapportOperation;
import com.dossiersmedicaux.repository.RapportOperationRepository;
import com.dossiersmedicaux.service.RapportOperationService;


@Service
public class RapportOperationServiceImpl implements RapportOperationService{



    @Autowired
    private RapportOperationRepository rapportOperationRepository;

    @Override
    @Transactional
    public List < RapportOperation > getRapportOperations() {
        return rapportOperationRepository.findAll();
    }

    @Override
    @Transactional
    public void saveRapportOperation(RapportOperation therapportOperation) {
        rapportOperationRepository.save(therapportOperation);
    }

    @Override
    @Transactional
    public RapportOperation getRapportOperation(int id) throws ResourceNotFoundException {
    	 return rapportOperationRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteRapportOperation(int theId) {
        rapportOperationRepository.deleteById(theId);
    }
 
}

