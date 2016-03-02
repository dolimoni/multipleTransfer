package org.adria.virementMultiple.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ParametrageCompteInclusSms {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	

	private String numCompteInclus;
	private String offreSouscrite;
	
	
	//private List<String> gsmList =new ArrayList<String>();
	private String facturation;
	private int nbreMaxAlerte;
	private int nbreMessageEnvoye;
	
	@OneToOne
	private ParametrageInfosSolde paraInfoSold;
	@OneToOne
	private ParametrageMiniReleve paraMiniReleve;
	
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<ParametrageEvenementSms> paraEvenementSms = new ArrayList<ParametrageEvenementSms>();
	
//	@OneToMany
//	private String gsm;
	
	@ManyToOne
	private ContratAbonnementSms contrat;
	
	
	public ParametrageCompteInclusSms(String numCompteInclus, String offreSouscrite, List<String> gsmList,
			String facturation, int nbreMaxAlerte, int nbreMessageEnvoye, ParametrageInfosSolde paraInfoSold,
			ParametrageMiniReleve paraMiniReleve, List<ParametrageEvenementSms> paraEvenementSms,
			ContratAbonnementSms contrat) {
		super();
		this.numCompteInclus = numCompteInclus;
		this.offreSouscrite = offreSouscrite;
		//this.gsmList = gsmList;
		this.facturation = facturation;
		this.nbreMaxAlerte = nbreMaxAlerte;
		this.nbreMessageEnvoye = nbreMessageEnvoye;
		this.paraInfoSold = paraInfoSold;
		this.paraMiniReleve = paraMiniReleve;
		this.paraEvenementSms = paraEvenementSms;
		this.contrat = contrat;
	}

	public ParametrageCompteInclusSms() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_ParametrageCompteInclusSms() {
		return id;
	}

	public void setId_ParametrageCompteInclusSms(Long id) {
		this.id= id;
	}

	public String getNumCompteInclus() {
		return numCompteInclus;
	}

	public void setNumCompteInclus(String numCompteInclus) {
		this.numCompteInclus = numCompteInclus;
	}

	public String getOffreSouscrite() {
		return offreSouscrite;
	}

	public void setOffreSouscrite(String offreSouscrite) {
		this.offreSouscrite = offreSouscrite;
	}

//	public List<String> getGsmList() {
//		return gsmList;
//	}
//
//	public void setGsmList(List<String> gsmList) {
//		this.gsmList = gsmList;
//	}

	public String getFacturation() {
		return facturation;
	}

	public void setFacturation(String facturation) {
		this.facturation = facturation;
	}

	public int getNbreMaxAlerte() {
		return nbreMaxAlerte;
	}

	public void setNbreMaxAlerte(int nbreMaxAlerte) {
		this.nbreMaxAlerte = nbreMaxAlerte;
	}

	public int getNbreMessageEnvoye() {
		return nbreMessageEnvoye;
	}

	public void setNbreMessageEnvoye(int nbreMessageEnvoye) {
		this.nbreMessageEnvoye = nbreMessageEnvoye;
	}

	public ParametrageInfosSolde getParaInfoSold() {
		return paraInfoSold;
	}

	public void setParaInfoSold(ParametrageInfosSolde paraInfoSold) {
		this.paraInfoSold = paraInfoSold;
	}

	public ParametrageMiniReleve getParaMiniReleve() {
		return paraMiniReleve;
	}

	public void setParaMiniReleve(ParametrageMiniReleve paraMiniReleve) {
		this.paraMiniReleve = paraMiniReleve;
	}

	public List<ParametrageEvenementSms> getParaEvenementSms() {
		return paraEvenementSms;
	}

	public void setParaEvenementSms(List<ParametrageEvenementSms> paraEvenementSms) {
		this.paraEvenementSms = paraEvenementSms;
	}

	public ContratAbonnementSms getContrat() {
		return contrat;
	}

	public void setContrat(ContratAbonnementSms contrat) {
		this.contrat = contrat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
