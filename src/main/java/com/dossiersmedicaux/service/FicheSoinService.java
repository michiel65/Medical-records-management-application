package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.FicheSoin;



public interface FicheSoinService {

    public List < FicheSoin > getFicheSoins();

    public void saveFicheSoin(FicheSoin ficheSoin);

    public FicheSoin getFicheSoin(int theId) throws ResourceNotFoundException;

    public void deleteFicheSoin(int theId) throws ResourceNotFoundException;


}