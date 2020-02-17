package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Prescription" database table.
 * 
 */
@Entity
@Table(name="\"Prescription\"")
@NamedQuery(name="Prescription.findAll", query="SELECT p FROM Prescription p")
public class Prescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String indication;

	private String periode;

	//bi-directional many-to-one association to FicheConsultattion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fichecon", updatable = false, insertable = false)
	private FicheConsultattion ficheConsultattion1;

	//bi-directional many-to-one association to FicheConsultattion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fichecon", updatable = false, insertable = false)
	private FicheConsultattion ficheConsultattion2;

	public Prescription() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIndication() {
		return this.indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public String getPeriode() {
		return this.periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
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