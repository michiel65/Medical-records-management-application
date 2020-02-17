package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Hopital" database table.
 * 
 */
@Entity
@Table(name="\"Hopital\"")
@NamedQuery(name="Hopital.findAll", query="SELECT h FROM Hopital h")
public class Hopital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String adresse;

	private String coordonnee;

	private String description;

	private String nom;

	//bi-directional many-to-one association to Medecin
	@OneToMany(mappedBy="hopital1")
	private List<Medecin> medecins1;

	//bi-directional many-to-one association to Medecin
	@OneToMany(mappedBy="hopital2")
	private List<Medecin> medecins2;

	public Hopital() {
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

	public String getCoordonnee() {
		return this.coordonnee;
	}

	public void setCoordonnee(String coordonnee) {
		this.coordonnee = coordonnee;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Medecin> getMedecins1() {
		return this.medecins1;
	}

	public void setMedecins1(List<Medecin> medecins1) {
		this.medecins1 = medecins1;
	}

	public Medecin addMedecins1(Medecin medecins1) {
		getMedecins1().add(medecins1);
		medecins1.setHopital1(this);

		return medecins1;
	}

	public Medecin removeMedecins1(Medecin medecins1) {
		getMedecins1().remove(medecins1);
		medecins1.setHopital1(null);

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
		medecins2.setHopital2(this);

		return medecins2;
	}

	public Medecin removeMedecins2(Medecin medecins2) {
		getMedecins2().remove(medecins2);
		medecins2.setHopital2(null);

		return medecins2;
	}

}