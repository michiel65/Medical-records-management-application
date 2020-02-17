package com.dossiersmedicaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dossiersmedicaux.model.Medecin;



@Repository("medecinRepository")
public interface MedecinRepository  extends JpaRepository<Medecin, Integer> {

	

}
