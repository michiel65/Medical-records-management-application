package com.dossiersmedicaux.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dossiersmedicaux.model.RapportAnalyse;



@Repository("rapportAnalyseRepository")
public interface RapportAnalyseRepository  extends JpaRepository<RapportAnalyse, Integer> {

	

}

