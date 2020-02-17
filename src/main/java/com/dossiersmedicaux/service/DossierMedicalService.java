package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.DossierMedical;



public interface DossierMedicalService {

    public List < DossierMedical > getDossierMedicals();

    public void saveDossierMedical(DossierMedical dossier);

    public DossierMedical getDossierMedical(int theId) throws ResourceNotFoundException;

    public void deleteDossierMedical(int theId) throws ResourceNotFoundException;


}