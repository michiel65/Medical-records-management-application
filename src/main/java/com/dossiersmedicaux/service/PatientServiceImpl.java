package com.dossiersmedicaux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Patient;
import com.dossiersmedicaux.repository.PatientRepository;
import com.dossiersmedicaux.service.PatientService;


@Service
public class PatientServiceImpl implements PatientService{



    @Autowired
    private PatientRepository patientRepository;

    @Override
    @Transactional
    public List < Patient > getPatients() {
        return patientRepository.findAll();
    }

    @Override
    @Transactional
    public void savePatient(Patient thepatient) {
        patientRepository.save(thepatient);
    }

    @Override
    @Transactional
    public Patient getPatient(int id) throws ResourceNotFoundException {
    	 return patientRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deletePatient(int theId) {
        patientRepository.deleteById(theId);
    }
 
}

