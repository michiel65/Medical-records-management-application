package com.dossiersmedicaux.service;

import java.util.List;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Consultation;



public interface ConsultationService {

    public List < Consultation > getConsultations();

    public void saveConsultation(Consultation consult);

    public Consultation getConsultation(int theId) throws ResourceNotFoundException;

    public void deleteConsultation(int theId) throws ResourceNotFoundException;



}