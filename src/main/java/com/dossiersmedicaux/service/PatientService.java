package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Patient;



public interface PatientService {

    public List < Patient > getPatients();

    public void savePatient(Patient patient);

    public Patient getPatient(int theId) throws ResourceNotFoundException;

    public void deletePatient(int theId) throws ResourceNotFoundException;


	
}