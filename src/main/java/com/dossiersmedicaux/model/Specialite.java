package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Specialite" database table.
 * 
 */
@Entity
@Table(name="\"Specialite\"")
@NamedQuery(name="Specialite.findAll", query="SELECT s FROM Specialite s")
public class Specialite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String libelle;

	//bi-directional many-to-one association to Medecin
	@OneToMany(mappedBy="specialite1")
	private List<Medecin> medecins1;

	//bi-directional many-to-one association to Medecin
	@OneToMany(mappedBy="specialite2")
	private List<Medecin> medecins2;

	public Specialite() {
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

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Medecin> getMedecins1() {
		return this.medecins1;
	}

	public void setMedecins1(List<Medecin> medecins1) {
		this.medecins1 = medecins1;
	}

	public Medecin addMedecins1(Medecin medecins1) {
		getMedecins1().add(medecins1);
		medecins1.setSpecialite1(this);

		return medecins1;
	}

	public Medecin removeMedecins1(Medecin medecins1) {
		getMedecins1().remove(medecins1);
		medecins1.setSpecialite1(null);

		return medecins1;
	}

	public List<Medecin> getMedecins2() {
		return this.medecins2;
	}

	public void setMedecins2(List<Medecin> medecins2) {
		this.medecins2 = medecins2;
	}

	public Medecin addMedecins2(Medecin medecins2) {
		getMedecins2().add(medecins2);
		medecins2.setSpecialite2(this);

		return medecins2;
	}

	public Medecin removeMedecins2(Medecin medecins2) {
		getMedecins2().remove(medecins2);
		medecins2.setSpecialite2(null);

		return medecins2;
	}

}