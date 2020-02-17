package com.dossiersmedicaux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.DossierMedical;
import com.dossiersmedicaux.repository.DossierMedicalRepository;
import com.dossiersmedicaux.service.DossierMedicalService;


@Service
public class DossierMedicalServiceImpl implements DossierMedicalService{



    @Autowired
    private DossierMedicalRepository dossierRepository;

    @Override
    @Transactional
    public List < DossierMedical > getDossierMedicals() {
        return dossierRepository.findAll();
    }

    @Override
    @Transactional
    public void saveDossierMedical(DossierMedical thedossier) {
        dossierRepository.save(thedossier);
    }

    @Override
    @Transactional
    public DossierMedical getDossierMedical(int id) throws ResourceNotFoundException {
    	 return dossierRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteDossierMedical(int theId) {
        dossierRepository.deleteById(theId);
    }
   
}


