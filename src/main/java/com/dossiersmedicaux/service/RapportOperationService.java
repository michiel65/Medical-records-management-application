package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.RapportOperation;



public interface RapportOperationService {

    public List < RapportOperation > getRapportOperations();

    public void saveRapportOperation(RapportOperation rapportOperation);

    public RapportOperation getRapportOperation(int theId) throws ResourceNotFoundException;

    public void deleteRapportOperation(int theId) throws ResourceNotFoundException;


}