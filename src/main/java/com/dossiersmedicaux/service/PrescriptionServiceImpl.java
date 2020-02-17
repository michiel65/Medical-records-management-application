package com.dossiersmedicaux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Prescription;
import com.dossiersmedicaux.repository.PrescriptionRepository;
import com.dossiersmedicaux.service.PrescriptionService;


@Service
public class PrescriptionServiceImpl implements PrescriptionService{



    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    @Transactional
    public List < Prescription > getPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @Override
    @Transactional
    public void savePrescription(Prescription theprescription) {
        prescriptionRepository.save(theprescription);
    }

    @Override
    @Transactional
    public Prescription getPrescription(int id) throws ResourceNotFoundException {
    	 return prescriptionRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deletePrescription(int theId) {
        prescriptionRepository.deleteById(theId);
    }
    
   
}

