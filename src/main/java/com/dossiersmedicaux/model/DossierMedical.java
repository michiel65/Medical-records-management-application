package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "DossierMedical" database table.
 * 
 */
@Entity
@Table(name="\"DossierMedical\"")
@NamedQuery(name="DossierMedical.findAll", query="SELECT d FROM DossierMedical d")
public class DossierMedical implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="code_acces")
	private String codeAcces;

	@Temporal(TemporalType.DATE)
	@Column(name="date_creation")
	private Date dateCreation;

	//bi-directional many-to-one association to Patient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_patient", updatable = false, insertable = false)
	private Patient patient1;

	//bi-directional many-to-one association to Patient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_patient", updatable = false, insertable = false)
	private Patient patient2;

	//bi-directional many-to-one association to FicheSoin
	@OneToMany(mappedBy="dossierMedical1")
	private List<FicheSoin> ficheSoins1;

	//bi-directional many-to-one association to FicheSoin
	@OneToMany(mappedBy="dossierMedical2")
	private List<FicheSoin> ficheSoins2;

	public DossierMedical() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeAcces() {
		return this.codeAcces;
	}

	public void setCodeAcces(String codeAcces) {
		this.codeAcces = codeAcces;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Patient getPatient1() {
		return this.patient1;
	}

	public void setPatient1(Patient patient1) {
		this.patient1 = patient1;
	}

	public Patient getPatient2() {
		return this.patient2;
	}

	public void setPatient2(Patient patient2) {
		this.patient2 = patient2;
	}

	public List<FicheSoin> getFicheSoins1() {
		return this.ficheSoins1;
	}

	public void setFicheSoins1(List<FicheSoin> ficheSoins1) {
		this.ficheSoins1 = ficheSoins1;
	}

	public FicheSoin addFicheSoins1(FicheSoin ficheSoins1) {
		getFicheSoins1().add(ficheSoins1);
		ficheSoins1.setDossierMedical1(this);

		return ficheSoins1;
	}

	public FicheSoin removeFicheSoins1(FicheSoin ficheSoins1) {
		getFicheSoins1().remove(ficheSoins1);
		ficheSoins1.setDossierMedical1(null);

		return ficheSoins1;
	}

	public List<FicheSoin> getFicheSoins2() {
		return this.ficheSoins2;
	}

	public void setFicheSoins2(List<FicheSoin> ficheSoins2) {
		this.ficheSoins2 = ficheSoins2;
	}

	public FicheSoin addFicheSoins2(FicheSoin ficheSoins2) {
		getFicheSoins2().add(ficheSoins2);
		ficheSoins2.setDossierMedical2(this);

		return ficheSoins2;
	}

	public FicheSoin removeFicheSoins2(FicheSoin ficheSoins2) {
		getFicheSoins2().remove(ficheSoins2);
		ficheSoins2.setDossierMedical2(null);

		return ficheSoins2;
	}

}