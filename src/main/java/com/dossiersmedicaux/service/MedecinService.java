package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Medecin;



public interface MedecinService {

    public List < Medecin > getMedecins();

    public void saveMedecin(Medecin person);

    public Medecin getMedecin(int theId) throws ResourceNotFoundException;

    public void deleteMedecin(int theId) throws ResourceNotFoundException;

}