package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Medecin" database table.
 * 
 */
@Entity
@Table(name="\"Medecin\"")
@NamedQuery(name="Medecin.findAll", query="SELECT m FROM Medecin m")
public class Medecin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personne")
	private Integer idPersonne;

	//bi-directional many-to-one association to FicheConsultattion
	@OneToMany(mappedBy="medecin1")
	private List<FicheConsultattion> ficheConsultattions1;

	//bi-directional many-to-one association to FicheConsultattion
	@OneToMany(mappedBy="medecin2")
	private List<FicheConsultattion> ficheConsultattions2;

	//bi-directional many-to-one association to Hopital
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_hopital", updatable = false, insertable = false)
	private Hopital hopital1;

	//bi-directional many-to-one association to Hopital
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_hopital", updatable = false, insertable = false)
	private Hopital hopital2;

	//bi-directional one-to-one association to Personne
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="id_personne")
	private Personne personne;

	//bi-directional many-to-one association to Specialite
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_specialite", updatable = false, insertable = false)
	private Specialite specialite1;

	//bi-directional many-to-one association to Specialite
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_specialite", updatable = false, insertable = false)
	private Specialite specialite2;

	public Medecin() {
	}

	public Integer getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	public List<FicheConsultattion> getFicheConsultattions1() {
		return this.ficheConsultattions1;
	}

	public void setFicheConsultattions1(List<FicheConsultattion> ficheConsultattions1) {
		this.ficheConsultattions1 = ficheConsultattions1;
	}

	public FicheConsultattion addFicheConsultattions1(FicheConsultattion ficheConsultattions1) {
		getFicheConsultattions1().add(ficheConsultattions1);
		ficheConsultattions1.setMedecin1(this);

		return ficheConsultattions1;
	}

	public FicheConsultattion removeFicheConsultattions1(FicheConsultattion ficheConsultattions1) {
		getFicheConsultattions1().remove(ficheConsultattions1);
		ficheConsultattions1.setMedecin1(null);

		return ficheConsultattions1;
	}

	public List<FicheConsultattion> getFicheConsultattions2() {
		return this.ficheConsultattions2;
	}

	public void setFicheConsultattions2(List<FicheConsultattion> ficheConsultattions2) {
		this.ficheConsultattions2 = ficheConsultattions2;
	}

	public FicheConsultattion addFicheConsultattions2(FicheConsultattion ficheConsultattions2) {
		getFicheConsultattions2().add(ficheConsultattions2);
		ficheConsultattions2.setMedecin2(this);

		return ficheConsultattions2;
	}

	public FicheConsultattion removeFicheConsultattions2(FicheConsultattion ficheConsultattions2) {
		getFicheConsultattions2().remove(ficheConsultattions2);
		ficheConsultattions2.setMedecin2(null);

		return ficheConsultattions2;
	}

	public Hopital getHopital1() {
		return this.hopital1;
	}

	public void setHopital1(Hopital hopital1) {
		this.hopital1 = hopital1;
	}

	public Hopital getHopital2() {
		return this.hopital2;
	}

	public void setHopital2(Hopital hopital2) {
		this.hopital2 = hopital2;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Specialite getSpecialite1() {
		return this.specialite1;
	}

	public void setSpecialite1(Specialite specialite1) {
		this.specialite1 = specialite1;
	}

	public Specialite getSpecialite2() {
		return this.specialite2;
	}

	public void setSpecialite2(Specialite specialite2) {
		this.specialite2 = specialite2;
	}

}