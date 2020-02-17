package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.FicheConsultattion;



public interface FicheConsultattionService {

    public List < FicheConsultattion > getFicheConsultattions();

    public void saveFicheConsultattion(FicheConsultattion ficheconsult);

    public FicheConsultattion getFicheConsultattion(int theId) throws ResourceNotFoundException;

    public void deleteFicheConsultattion(int theId) throws ResourceNotFoundException;


}