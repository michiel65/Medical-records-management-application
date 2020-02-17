package com.dossiersmedicaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dossiersmedicaux.model.RapportOperation;



@Repository("rapportOperationRepository")
public interface RapportOperationRepository  extends JpaRepository<RapportOperation, Integer> {

	

}
