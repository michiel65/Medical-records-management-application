package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Specialite;



public interface SpecialiteService {

    public List < Specialite > getSpecialites();

    public void saveSpecialite(Specialite specialite);

    public Specialite getSpecialite(int theId) throws ResourceNotFoundException;

    public void deleteSpecialite(int theId) throws ResourceNotFoundException;


}