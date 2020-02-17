package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.RapportAnalyse;



public interface RapportAnalyseService {

    public List < RapportAnalyse > getRapportAnalyses();

    public void saveRapportAnalyse(RapportAnalyse rapportAnalyse);

    public RapportAnalyse getRapportAnalyse(int theId) throws ResourceNotFoundException;

    public void deleteRapportAnalyse(int theId) throws ResourceNotFoundException;



}