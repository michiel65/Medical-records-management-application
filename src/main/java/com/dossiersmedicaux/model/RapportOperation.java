package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "RapportOperation" database table.
 * 
 */
@Entity
@Table(name="\"RapportOperation\"")
@NamedQuery(name="RapportOperation.findAll", query="SELECT r FROM RapportOperation r")
public class RapportOperation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String activitemedicale;

	@Temporal(TemporalType.DATE)
	@Column(name="date_heure")
	private Date dateHeure;

	private String observation;

	//bi-directional many-to-one association to FicheConsultattion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fichecons", updatable = false, insertable = false)
	private FicheConsultattion ficheConsultattion1;

	//bi-directional many-to-one association to FicheConsultattion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fichecons", updatable = false, insertable = false)
	private FicheConsultattion ficheConsultattion2;

	public RapportOperation() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivitemedicale() {
		return this.activitemedicale;
	}

	public void setActivitemedicale(String activitemedicale) {
		this.activitemedicale = activitemedicale;
	}

	public Date getDateHeure() {
		return this.dateHeure;
	}

	public void setDateHeure(Date dateHeure) {
		this.dateHeure = dateHeure;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
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

}