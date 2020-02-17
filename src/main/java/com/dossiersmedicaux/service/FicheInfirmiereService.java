package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.FicheInfirmiere;



public interface FicheInfirmiereService {

    public List < FicheInfirmiere > getFicheInfirmieres();

    public void saveFicheInfirmiere(FicheInfirmiere ficheInfirmiere);

    public FicheInfirmiere getFicheInfirmiere(int theId) throws ResourceNotFoundException;

    public void deleteFicheInfirmiere(int theId) throws ResourceNotFoundException;


}
