package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Personne;



public interface PersonneService {

    public List < Personne > getPersonnes();

    public void savePersonne(Personne person);

    public Personne getPersonne(int theId) throws ResourceNotFoundException;

    public void deletePersonne(int theId) throws ResourceNotFoundException;

	public Personne findByLogin(String login);
}