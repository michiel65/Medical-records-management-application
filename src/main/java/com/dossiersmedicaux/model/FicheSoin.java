package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "FicheSoins" database table.
 * 
 */
@Entity
@Table(name="\"FicheSoins\"")
@NamedQuery(name="FicheSoin.findAll", query="SELECT f FROM FicheSoin f")
public class FicheSoin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_creation")
	private Date dateCreation;

	private String description;

	private String rubrique;

	//bi-directional many-to-one association to FicheConsultattion
	@OneToMany(mappedBy="ficheSoin")
	private List<FicheConsultattion> ficheConsultattions;

	//bi-directional many-to-one association to FicheInfirmiere
	@OneToMany(mappedBy="ficheSoin1")
	private List<FicheInfirmiere> ficheInfirmieres1;

	//bi-directional many-to-one association to FicheInfirmiere
	@OneToMany(mappedBy="ficheSoin2")
	private List<FicheInfirmiere> ficheInfirmieres2;

	//bi-directional many-to-one association to DossierMedical
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_dossierm", updatable = false, insertable = false)
	private DossierMedical dossierMedical1;

	//bi-directional many-to-one association to DossierMedical
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_dossierm", updatable = false, insertable = false)
	private DossierMedical dossierMedical2;

	public FicheSoin() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRubrique() {
		return this.rubrique;
	}

	public void setRubrique(String rubrique) {
		this.rubrique = rubrique;
	}

	public List<FicheConsultattion> getFicheConsultattions() {
		return this.ficheConsultattions;
	}

	public void setFicheConsultattions(List<FicheConsultattion> ficheConsultattions) {
		this.ficheConsultattions = ficheConsultattions;
	}

	public FicheConsultattion addFicheConsultattion(FicheConsultattion ficheConsultattion) {
		getFicheConsultattions().add(ficheConsultattion);
		ficheConsultattion.setFicheSoin(this);

		return ficheConsultattion;
	}

	public FicheConsultattion removeFicheConsultattion(FicheConsultattion ficheConsultattion) {
		getFicheConsultattions().remove(ficheConsultattion);
		ficheConsultattion.setFicheSoin(null);

		return ficheConsultattion;
	}

	public List<FicheInfirmiere> getFicheInfirmieres1() {
		return this.ficheInfirmieres1;
	}

	public void setFicheInfirmieres1(List<FicheInfirmiere> ficheInfirmieres1) {
		this.ficheInfirmieres1 = ficheInfirmieres1;
	}

	public FicheInfirmiere addFicheInfirmieres1(FicheInfirmiere ficheInfirmieres1) {
		getFicheInfirmieres1().add(ficheInfirmieres1);
		ficheInfirmieres1.setFicheSoin1(this);

		return ficheInfirmieres1;
	}

	public FicheInfirmiere removeFicheInfirmieres1(FicheInfirmiere ficheInfirmieres1) {
		getFicheInfirmieres1().remove(ficheInfirmieres1);
		ficheInfirmieres1.setFicheSoin1(null);

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
		ficheInfirmieres2.setFicheSoin2(this);

		return ficheInfirmieres2;
	}

	public FicheInfirmiere removeFicheInfirmieres2(FicheInfirmiere ficheInfirmieres2) {
		getFicheInfirmieres2().remove(ficheInfirmieres2);
		ficheInfirmieres2.setFicheSoin2(null);

		return ficheInfirmieres2;
	}

	public DossierMedical getDossierMedical1() {
		return this.dossierMedical1;
	}

	public void setDossierMedical1(DossierMedical dossierMedical1) {
		this.dossierMedical1 = dossierMedical1;
	}

	public DossierMedical getDossierMedical2() {
		return this.dossierMedical2;
	}

	public void setDossierMedical2(DossierMedical dossierMedical2) {
		this.dossierMedical2 = dossierMedical2;
	}

}