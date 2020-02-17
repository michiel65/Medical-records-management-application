package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "RapportAnalyse" database table.
 * 
 */
@Entity
@Table(name="\"RapportAnalyse\"")
@NamedQuery(name="RapportAnalyse.findAll", query="SELECT r FROM RapportAnalyse r")
public class RapportAnalyse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_heure")
	private Date dateHeure;

	private String description;

	private String resultat;

	//bi-directional many-to-one association to Consultation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ficheconsul", updatable = false, insertable = false)
	private Consultation consultation1;

	//bi-directional many-to-one association to Consultation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ficheconsul", updatable = false, insertable = false)
	private Consultation consultation2;

	public RapportAnalyse() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateHeure() {
		return this.dateHeure;
	}

	public void setDateHeure(Date dateHeure) {
		this.dateHeure = dateHeure;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResultat() {
		return this.resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public Consultation getConsultation1() {
		return this.consultation1;
	}

	public void setConsultation1(Consultation consultation1) {
		this.consultation1 = consultation1;
	}

	public Consultation getConsultation2() {
		return this.consultation2;
	}

	public void setConsultation2(Consultation consultation2) {
		this.consultation2 = consultation2;
	}

}