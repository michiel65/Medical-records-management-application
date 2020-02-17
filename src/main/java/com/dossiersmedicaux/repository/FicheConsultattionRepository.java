package com.dossiersmedicaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dossiersmedicaux.model.FicheConsultattion;



@Repository("ficheConsultationRepository")
public interface FicheConsultattionRepository  extends JpaRepository<FicheConsultattion, Integer> {

	

}
