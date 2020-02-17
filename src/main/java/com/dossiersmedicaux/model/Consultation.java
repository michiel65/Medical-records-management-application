package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "Consultation" database table.
 * 
 */
@Entity
@Table(name="\"Consultation\"")
@NamedQuery(name="Consultation.findAll", query="SELECT c FROM Consultation c")
public class Consultation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_consultation")
	private Date dateConsultation;

	@Column(name="etat_consultation")
	private String etatConsultation;

	@Column(name="heure_consultation")
	private String heureConsultation;

	@Column(name="lieu_consultation")
	private String lieuConsultation;

	//bi-directional many-to-one association to FicheConsultattion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fichec", updatable = false, insertable = false)
	private FicheConsultattion ficheConsultattion1;

	//bi-directional many-to-one association to FicheConsultattion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fichec", updatable = false, insertable = false)
	private FicheConsultattion ficheConsultattion2;

	//bi-directional many-to-one association to RapportAnalyse
	@OneToMany(mappedBy="consultation1")
	private List<RapportAnalyse> rapportAnalyses1;

	//bi-directional many-to-one association to RapportAnalyse
	@OneToMany(mappedBy="consultation2")
	private List<RapportAnalyse> rapportAnalyses2;

	public Consultation() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateConsultation() {
		return this.dateConsultation;
	}

	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public String getEtatConsultation() {
		return this.etatConsultation;
	}

	public void setEtatConsultation(String etatConsultation) {
		this.etatConsultation = etatConsultation;
	}

	public String getHeureConsultation() {
		return this.heureConsultation;
	}

	public void setHeureConsultation(String heureConsultation) {
		this.heureConsultation = heureConsultation;
	}

	public String getLieuConsultation() {
		return this.lieuConsultation;
	}

	public void setLieuConsultation(String lieuConsultation) {
		this.lieuConsultation = lieuConsultation;
	}

	public FicheConsultattion getFicheConsultattion1() {
		return this.ficheConsultattion1;
	}

	public void setFicheConsultattion1(FicheConsultattion ficheConsultattion1) {
		this.ficheConsultattion1 = ficheConsultattion1;
	}

	public FicheConsultattion getFicheConsultattion2() {
		return this.ficheConsultattion2;
	}

	public void setFicheConsultattion2(FicheConsultattion ficheConsultattion2) {
		this.ficheConsultattion2 = ficheConsultattion2;
	}

	public List<RapportAnalyse> getRapportAnalyses1() {
		return this.rapportAnalyses1;
	}

	public void setRapportAnalyses1(List<RapportAnalyse> rapportAnalyses1) {
		this.rapportAnalyses1 = rapportAnalyses1;
	}

	public RapportAnalyse addRapportAnalyses1(RapportAnalyse rapportAnalyses1) {
		getRapportAnalyses1().add(rapportAnalyses1);
		rapportAnalyses1.setConsultation1(this);

		return rapportAnalyses1;
	}

	public RapportAnalyse removeRapportAnalyses1(RapportAnalyse rapportAnalyses1) {
		getRapportAnalyses1().remove(rapportAnalyses1);
		rapportAnalyses1.setConsultation1(null);

		return rapportAnalyses1;
	}

	public List<RapportAnalyse> getRapportAnalyses2() {
		return this.rapportAnalyses2;
	}

	public void setRapportAnalyses2(List<RapportAnalyse> rapportAnalyses2) {
		this.rapportAnalyses2 = rapportAnalyses2;
	}

	public RapportAnalyse addRapportAnalyses2(RapportAnalyse rapportAnalyses2) {
		getRapportAnalyses2().add(rapportAnalyses2);
		rapportAnalyses2.setConsultation2(this);

		return rapportAnalyses2;
	}

	public RapportAnalyse removeRapportAnalyses2(RapportAnalyse rapportAnalyses2) {
		getRapportAnalyses2().remove(rapportAnalyses2);
		rapportAnalyses2.setConsultation2(null);

		return rapportAnalyses2;
	}

}