package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Prescription;



public interface PrescriptionService {

    public List < Prescription > getPrescriptions();

    public void savePrescription(Prescription presciption);

    public Prescription getPrescription(int theId) throws ResourceNotFoundException;

    public void deletePrescription(int theId) throws ResourceNotFoundException;


	
}