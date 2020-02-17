package com.dossiersmedicaux.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dossiersmedicaux.model.FicheSoin;



@Repository("ficheSoinRepository")
public interface FicheSoinRepository  extends JpaRepository<FicheSoin, Integer> {

	

}
