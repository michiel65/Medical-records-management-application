package com.dossiersmedicaux.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossiersmedicaux.exception.ResourceNotFoundException;
import com.dossiersmedicaux.model.Consultation;
import com.dossiersmedicaux.repository.ConsultationRepository;
import com.dossiersmedicaux.service.ConsultationService;


@Service
public class ConsultationServiceImpl implements ConsultationService{



    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    @Transactional
    public List < Consultation > getConsultations() {
        return consultationRepository.findAll();
    }

    @Override
    @Transactional
    public void saveConsultation(Consultation theConsult) {
        consultationRepository.save(theConsult);
    }

    @Override
    @Transactional
    public Consultation getConsultation(int id) throws ResourceNotFoundException {
    	 return consultationRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteConsultation(int theId) {
        consultationRepository.deleteById(theId);
    }
    
   
}


