package com.dossiersmedicaux.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dossiersmedicaux.model.FicheInfirmiere;



@Repository("ficheInfirmiereRepository")
public interface FicheInfirmiereRepository  extends JpaRepository<FicheInfirmiere, Integer> {

	

}
