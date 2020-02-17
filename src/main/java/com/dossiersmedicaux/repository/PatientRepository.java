package com.dossiersmedicaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dossiersmedicaux.model.Patient;



@Repository("patientRepository")
public interface PatientRepository  extends JpaRepository<Patient, Integer> {

	

}
