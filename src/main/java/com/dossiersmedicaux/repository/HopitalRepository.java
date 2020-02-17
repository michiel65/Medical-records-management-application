package com.dossiersmedicaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dossiersmedicaux.model.Hopital;



@Repository("hopitalRepository")
public interface HopitalRepository  extends JpaRepository<Hopital, Integer> {

	

}

