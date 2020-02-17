package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Hopital;



public interface HopitalService {

    public List < Hopital > getHopitals();

    public void saveHopital(Hopital hopital);

    public Hopital getHopital(int theId) throws ResourceNotFoundException;

    public void deleteHopital(int theId) throws ResourceNotFoundException;


}