package org.adria.virementMultiple.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class ContratAbonnementSms {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Version
	private Long version;
	private String numContrat;
	private String client;
	
	@OneToMany(fetch=FetchType.LAZY)
	List<ParametrageCompteInclusSms> compteIncluSms = new ArrayList<ParametrageCompteInclusSms>();
	
	private String numCompteFacturation;
	private String statut="Actif";
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getNumContrat() {
		return numContrat;
	}
	public void setNumContrat(String numContrat) {
		this.numContrat = numContrat;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public List<ParametrageCompteInclusSms> getCompteIncluSms() {
		return compteIncluSms;
	}
	public void setCompteIncluSms(List<ParametrageCompteInclusSms> compteIncluSms) {
		this.compteIncluSms = compteIncluSms;
	}
	
	public String getNumCompteFacturation() {
		return numCompteFacturation;
	}
	public void setNumCompteFacturation(String numCompteFacturation) {
		this.numCompteFacturation = numCompteFacturation;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public ContratAbonnementSms(String numContrat, String client, List<ParametrageCompteInclusSms> compteIncluSms,
			String numCompteSupportFacturation, String statut) {
		super();
		this.numContrat = numContrat;
		this.client = client;
		this.compteIncluSms = compteIncluSms;
		this.numCompteFacturation = numCompteSupportFacturation;
		this.statut = statut;
	}
	public ContratAbonnementSms() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
