package com.dossiersmedicaux.repository;


	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dossiersmedicaux.model.Personne;



	@Repository("personneRepository")
	public interface PersonneRepository  extends JpaRepository<Personne, Integer> {
	
		public Personne findByLogin(String login);

	}