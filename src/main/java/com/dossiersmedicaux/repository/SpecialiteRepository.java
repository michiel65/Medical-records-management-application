package com.dossiersmedicaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dossiersmedicaux.model.Specialite;



@Repository("specialiteRepository")
public interface SpecialiteRepository  extends JpaRepository<Specialite, Integer> {

	

}
