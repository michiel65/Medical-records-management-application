package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Patient" database table.
 * 
 */
@Entity
@Table(name="\"Patient\"")
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personne")
	private Integer idPersonne;

	//bi-directional many-to-one association to DossierMedical
	@OneToMany(mappedBy="patient1")
	private List<DossierMedical> dossierMedicals1;

	//bi-directional many-to-one association to DossierMedical
	@OneToMany(mappedBy="patient2")
	private List<DossierMedical> dossierMedicals2;

	//bi-directional many-to-one association to Personne
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_createur", updatable = false, insertable = false)
	private Personne personne1;

	//bi-directional many-to-one association to Personne
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_createur", updatable = false, insertable = false)
	private Personne personne2;

	//bi-directional one-to-one association to Personne
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_personne")
	private Personne personne3;

	public Patient() {
	}

	public Integer getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	public List<DossierMedical> getDossierMedicals1() {
		return this.dossierMedicals1;
	}

	public void setDossierMedicals1(List<DossierMedical> dossierMedicals1) {
		this.dossierMedicals1 = dossierMedicals1;
	}

	public DossierMedical addDossierMedicals1(DossierMedical dossierMedicals1) {
		getDossierMedicals1().add(dossierMedicals1);
		dossierMedicals1.setPatient1(this);

		return dossierMedicals1;
	}

	public DossierMedical removeDossierMedicals1(DossierMedical dossierMedicals1) {
		getDossierMedicals1().remove(dossierMedicals1);
		dossierMedicals1.setPatient1(null);

		return dossierMedicals1;
	}

	public List<DossierMedical> getDossierMedicals2() {
		return this.dossierMedicals2;
	}

	public void setDossierMedicals2(List<DossierMedical> dossierMedicals2) {
		this.dossierMedicals2 = dossierMedicals2;
	}

	public DossierMedical addDossierMedicals2(DossierMedical dossierMedicals2) {
		getDossierMedicals2().add(dossierMedicals2);
		dossierMedicals2.setPatient2(this);

		return dossierMedicals2;
	}

	public DossierMedical removeDossierMedicals2(DossierMedical dossierMedicals2) {
		getDossierMedicals2().remove(dossierMedicals2);
		dossierMedicals2.setPatient2(null);

		return dossierMedicals2;
	}

	public Personne getPersonne1() {
		return this.personne1;
	}

	public void setPersonne1(Personne personne1) {
		this.personne1 = personne1;
	}

	public Personne getPersonne2() {
		return this.personne2;
	}

	public void setPersonne2(Personne personne2) {
		this.personne2 = personne2;
	}

	public Personne getPersonne3() {
		return this.personne3;
	}

	public void setPersonne3(Personne personne3) {
		this.personne3 = personne3;
	}

}