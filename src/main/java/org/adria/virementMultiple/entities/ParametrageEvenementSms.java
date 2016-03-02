package org.adria.virementMultiple.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ParametrageEvenementSms {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private String codeAlerteSms;
	private BigDecimal seuilDeclenchement;
	private String periodicite;
	private String horaireDebutEnvoi;
	private String horaireFinEnvoi;
	private Integer jourEcheance;
	
	@ManyToOne
	private ParametrageCompteInclusSms compte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_ParametrageEvenementSms() {
		return id;
	}

	public void setId_ParametrageEvenementSms(Long id_ParametrageEvenementSms) {
		this.id= id_ParametrageEvenementSms;
	}

	public String getCodeAlerteSms() {
		return codeAlerteSms;
	}

	public void setCodeAlerteSms(String codeAlerteSms) {
		this.codeAlerteSms = codeAlerteSms;
	}

	public BigDecimal getSeuilDeclenchement() {
		return seuilDeclenchement;
	}

	public void setSeuilDeclenchement(BigDecimal seuilDeclenchement) {
		this.seuilDeclenchement = seuilDeclenchement;
	}

	public String getPeriodicite() {
		return periodicite;
	}

	public void setPeriodicite(String periodicite) {
		this.periodicite = periodicite;
	}

	public String getHoraireDebutEnvoi() {
		return horaireDebutEnvoi;
	}

	public void setHoraireDebutEnvoi(String horaireDebutEnvoi) {
		this.horaireDebutEnvoi = horaireDebutEnvoi;
	}

	public String getHoraireFinEnvoi() {
		return horaireFinEnvoi;
	}

	public void setHoraireFinEnvoi(String horaireFinEnvoi) {
		this.horaireFinEnvoi = horaireFinEnvoi;
	}

	public Integer getJourEcheance() {
		return jourEcheance;
	}

	public void setJourEcheance(Integer jourEcheance) {
		this.jourEcheance = jourEcheance;
	}

	public ParametrageCompteInclusSms getCompte() {
		return compte;
	}

	public void setCompte(ParametrageCompteInclusSms compte) {
		this.compte = compte;
	}

	public ParametrageEvenementSms(String codeAlerteSms, BigDecimal seuilDeclenchement, String periodicite,
			String horaireDebutEnvoi, String horaireFinEnvoi, Integer jourEcheance, ParametrageCompteInclusSms compte) {
		super();
		this.codeAlerteSms = codeAlerteSms;
		this.seuilDeclenchement = seuilDeclenchement;
		this.periodicite = periodicite;
		this.horaireDebutEnvoi = horaireDebutEnvoi;
		this.horaireFinEnvoi = horaireFinEnvoi;
		this.jourEcheance = jourEcheance;
		this.compte = compte;
	}

	public ParametrageEvenementSms() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
