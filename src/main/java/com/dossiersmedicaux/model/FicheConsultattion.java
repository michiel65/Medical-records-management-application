package com.dossiersmedicaux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "FicheConsultattion" database table.
 * 
 */
@Entity
@Table(name="\"FicheConsultattion\"")
@NamedQuery(name="FicheConsultattion.findAll", query="SELECT f FROM FicheConsultattion f")
public class FicheConsultattion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="compte_rendu")
	private String compteRendu;

	//bi-directional many-to-one association to Consultation
	@OneToMany(mappedBy="ficheConsultattion1")
	private List<Consultation> consultations1;

	//bi-directional many-to-one association to Consultation
	@OneToMany(mappedBy="ficheConsultattion2")
	private List<Consultation> consultations2;

	//bi-directional many-to-one association to FicheSoin
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fichesoins", updatable = false, insertable = false)
	private FicheSoin ficheSoin;

	//bi-directional many-to-one association to Medecin
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_medec")
	private Medecin medecin1;

	//bi-directional many-to-one association to Medecin
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_medec", updatable = false, insertable = false)
	private Medecin medecin2;

	//bi-directional many-to-one association to Prescription
	@OneToMany(mappedBy="ficheConsultattion1")
	private List<Prescription> prescriptions1;

	//bi-directional many-to-one association to Prescription
	@OneToMany(mappedBy="ficheConsultattion2")
	private List<Prescription> prescriptions2;

	//bi-directional many-to-one association to RapportOperation
	@OneToMany(mappedBy="ficheConsultattion1")
	private List<RapportOperation> rapportOperations1;

	//bi-directional many-to-one association to RapportOperation
	@OneToMany(mappedBy="ficheConsultattion2")
	private List<RapportOperation> rapportOperations2;

	public FicheConsultattion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompteRendu() {
		return this.compteRendu;
	}

	public void setCompteRendu(String compteRendu) {
		this.compteRendu = compteRendu;
	}

	public List<Consultation> getConsultations1() {
		return this.consultations1;
	}

	public void setConsultations1(List<Consultation> consultations1) {
		this.consultations1 = consultations1;
	}

	public Consultation addConsultations1(Consultation consultations1) {
		getConsultations1().add(consultations1);
		consultations1.setFicheConsultattion1(this);

		return consultations1;
	}

	public Consultation removeConsultations1(Consultation consultations1) {
		getConsultations1().remove(consultations1);
		consultations1.setFicheConsultattion1(null);

		return consultations1;
	}

	public List<Consultation> getConsultations2() {
		return this.consultations2;
	}

	public void setConsultations2(List<Consultation> consultations2) {
		this.consultations2 = consultations2;
	}

	public Consultation addConsultations2(Consultation consultations2) {
		getConsultations2().add(consultations2);
		consultations2.setFicheConsultattion2(this);

		return consultations2;
	}

	public Consultation removeConsultations2(Consultation consultations2) {
		getConsultations2().remove(consultations2);
		consultations2.setFicheConsultattion2(null);

		return consultations2;
	}

	public FicheSoin getFicheSoin() {
		return this.ficheSoin;
	}

	public void setFicheSoin(FicheSoin ficheSoin) {
		this.ficheSoin = ficheSoin;
	}

	public Medecin getMedecin1() {
		return this.medecin1;
	}

	public void setMedecin1(Medecin medecin1) {
		this.medecin1 = medecin1;
	}

	public Medecin getMedecin2() {
		return this.medecin2;
	}

	public void setMedecin2(Medecin medecin2) {
		this.medecin2 = medecin2;
	}

	public List<Prescription> getPrescriptions1() {
		return this.prescriptions1;
	}

	public void setPrescriptions1(List<Prescription> prescriptions1) {
		this.prescriptions1 = prescriptions1;
	}

	public Prescription addPrescriptions1(Prescription prescriptions1) {
		getPrescriptions1().add(prescriptions1);
		prescriptions1.setFicheConsultattion1(this);

		return prescriptions1;
	}

	public Prescription removePrescriptions1(Prescription prescriptions1) {
		getPrescriptions1().remove(prescriptions1);
		prescriptions1.setFicheConsultattion1(null);

		return prescriptions1;
	}

	public List<Prescription> getPrescriptions2() {
		return this.prescriptions2;
	}

	public void setPrescriptions2(List<Prescription> prescriptions2) {
		this.prescriptions2 = prescriptions2;
	}

	public Prescription addPrescriptions2(Prescription prescriptions2) {
		getPrescriptions2().add(prescriptions2);
		prescriptions2.setFicheConsultattion2(this);

		return prescriptions2;
	}

	public Prescription removePrescriptions2(Prescription prescriptions2) {
		getPrescriptions2().remove(prescriptions2);
		prescriptions2.setFicheConsultattion2(null);

		return prescriptions2;
	}

	public List<RapportOperation> getRapportOperations1() {
		return this.rapportOperations1;
	}

	public void setRapportOperations1(List<RapportOperation> rapportOperations1) {
		this.rapportOperations1 = rapportOperations1;
	}

	public RapportOperation addRapportOperations1(RapportOperation rapportOperations1) {
		getRapportOperations1().add(rapportOperations1);
		rapportOperations1.setFicheConsultattion1(this);

		return rapportOperations1;
	}

	public RapportOperation removeRapportOperations1(RapportOperation rapportOperations1) {
		getRapportOperations1().remove(rapportOperations1);
		rapportOperations1.setFicheConsultattion1(null);

		return rapportOperations1;
	}

	public List<RapportOperation> getRapportOperations2() {
		return this.rapportOperations2;
	}

	public void setRapportOperations2(List<RapportOperation> rapportOperations2) {
		this.rapportOperations2 = rapportOperations2;
	}

	public RapportOperation addRapportOperations2(RapportOperation rapportOperations2) {
		getRapportOperations2().add(rapportOperations2);
		rapportOperations2.setFicheConsultattion2(this);

		return rapportOperations2;
	}

	public RapportOperation removeRapportOperations2(RapportOperation rapportOperations2) {
		getRapportOperations2().remove(rapportOperations2);
		rapportOperations2.setFicheConsultattion2(null);

		return rapportOperations2;
	}

}