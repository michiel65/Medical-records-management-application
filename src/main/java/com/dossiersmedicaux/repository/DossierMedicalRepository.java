package com.dossiersmedicaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dossiersmedicaux.model.DossierMedical;



@Repository("dossierMedicalRepository")
public interface DossierMedicalRepository  extends JpaRepository<DossierMedical, Integer> {

	

}
