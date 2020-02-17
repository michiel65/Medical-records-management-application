package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "FicheInfirmiere" database table.
 * 
 */
@Entity
@Table(name="\"FicheInfirmiere\"")
@NamedQuery(name="FicheInfirmiere.findAll", query="SELECT f FROM FicheInfirmiere f")
public class FicheInfirmiere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_creation")
	private Date dateCreation;

	private String parametre;

	//bi-directional many-to-one association to FicheSoin
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fichesoins", updatable = false, insertable = false)
	private FicheSoin ficheSoin1;

	//bi-directional many-to-one association to FicheSoin
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fichesoins", updatable = false, insertable = false)
	private FicheSoin ficheSoin2;

	//bi-directional many-to-one association to Personne
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_infirmiere", updatable = false, insertable = false)
	private Personne personne1;

	//bi-directional many-to-one association to Personne
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_infirmiere", updatable = false, insertable = false)
	private Personne personne2;

	public FicheInfirmiere() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getParametre() {
		return this.parametre;
	}

	public void setParametre(String parametre) {
		this.parametre = parametre;
	}

	public FicheSoin getFicheSoin1() {
		return this.ficheSoin1;
	}

	public void setFicheSoin1(FicheSoin ficheSoin1) {
		this.ficheSoin1 = ficheSoin1;
	}

	public FicheSoin getFicheSoin2() {
		return this.ficheSoin2;
	}

	public void setFicheSoin2(FicheSoin ficheSoin2) {
		this.ficheSoin2 = ficheSoin2;
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

}