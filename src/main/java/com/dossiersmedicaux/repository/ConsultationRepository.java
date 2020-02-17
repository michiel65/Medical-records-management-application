package com.dossiersmedicaux.repository;


	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dossiersmedicaux.model.Consultation;



	@Repository("consultationRepository")
	public interface ConsultationRepository  extends JpaRepository<Consultation, Integer> {

		

	}

