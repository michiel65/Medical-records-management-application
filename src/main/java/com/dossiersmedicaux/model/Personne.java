package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "Personne" database table.
 * 
 */
@Entity
@Table(name="\"Personne\"")
@NamedQuery(name="Personne.findAll", query="SELECT p FROM Personne p")
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String adresse;

	private Integer age;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date datenais;

	private String email;

	private String lieunais;

	private String login;

	private String nom;

	private String password;

	private String prenom;

	private String profession;

	private String role;

	private String sexe;

	//bi-directional many-to-one association to FicheInfirmiere
	@OneToMany(mappedBy="personne1")
	private List<FicheInfirmiere> ficheInfirmieres1;

	//bi-directional many-to-one association to FicheInfirmiere
	@OneToMany(mappedBy="personne2")
	private List<FicheInfirmiere> ficheInfirmieres2;

	//bi-directional one-to-one association to Medecin
	@OneToOne(mappedBy="personne", fetch=FetchType.LAZY)
	private Medecin medecin;

	//bi-directional many-to-one association to Patient
	@OneToMany(mappedBy="personne1")
	private List<Patient> patients1;

	//bi-directional many-to-one association to Patient
	@OneToMany(mappedBy="personne2")
	private List<Patient> patients2;

	//bi-directional one-to-one association to Patient
	@OneToOne(mappedBy="personne3", fetch=FetchType.LAZY)
	private Patient patient;

	public Personne() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDatenais() {
		return this.datenais;
	}

	public void setDatenais(Date datenais) {
		this.datenais = datenais;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLieunais() {
		return this.lieunais;
	}

	public void setLieunais(String lieunais) {
		this.lieunais = lieunais;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public List<FicheInfirmiere> getFicheInfirmieres1() {
		return this.ficheInfirmieres1;
	}

	public void setFicheInfirmieres1(List<FicheInfirmiere> ficheInfirmieres1) {
		this.ficheInfirmieres1 = ficheInfirmieres1;
	}

	public FicheInfirmiere addFicheInfirmieres1(FicheInfirmiere ficheInfirmieres1) {
		getFicheInfirmieres1().add(ficheInfirmieres1);
		ficheInfirmieres1.setPersonne1(this);

		return ficheInfirmieres1;
	}

	public FicheInfirmiere removeFicheInfirmieres1(FicheInfirmiere ficheInfirmieres1) {
		getFicheInfirmieres1().remove(ficheInfirmieres1);
		ficheInfirmieres1.setPersonne1(null);

		return ficheInfirmieres1;
	}

	public List<FicheInfirmiere> getFicheInfirmieres2() {
		return this.ficheInfirmieres2;
	}

	public void setFicheInfirmieres2(List<FicheInfirmiere> ficheInfirmieres2) {
		this.ficheInfirmieres2 = ficheInfirmieres2;
	}

	public FicheInfirmiere addFicheInfirmieres2(FicheInfirmiere ficheInfirmieres2) {
		getFicheInfirmieres2().add(ficheInfirmieres2);
		ficheInfirmieres2.setPersonne2(this);

		return ficheInfirmieres2;
	}

	public FicheInfirmiere removeFicheInfirmieres2(FicheInfirmiere ficheInfirmieres2) {
		getFicheInfirmieres2().remove(ficheInfirmieres2);
		ficheInfirmieres2.setPersonne2(null);

		return ficheInfirmieres2;
	}

	public Medecin getMedecin() {
		return this.medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public List<Patient> getPatients1() {
		return this.patients1;
	}

	public void setPatients1(List<Patient> patients1) {
		this.patients1 = patients1;
	}

	public Patient addPatients1(Patient patients1) {
		getPatients1().add(patients1);
		patients1.setPersonne1(this);

		return patients1;
	}

	public Patient removePatients1(Patient patients1) {
		getPatients1().remove(patients1);
		patients1.setPersonne1(null);

		return patients1;
	}

	public List<Patient> getPatients2() {
		return this.patients2;
	}

	public void setPatients2(List<Patient> patients2) {
		this.patients2 = patients2;
	}

	public Patient addPatients2(Patient patients2) {
		getPatients2().add(patients2);
		patients2.setPersonne2(this);

		return patients2;
	}

	public Patient removePatients2(Patient patients2) {
		getPatients2().remove(patients2);
		patients2.setPersonne2(null);

		return patients2;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}