package org.adria.virementMultiple.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ParametrageInfosSolde {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	private ParametrageCompteInclusSms compte;

	public Long getId_ParametrageInfosSolde() {
		return id;
	}

	public void setId_ParametrageInfosSolde(Long id_ParametrageInfosSolde) {
		this.id= id_ParametrageInfosSolde;
	}

	public ParametrageCompteInclusSms getCompte() {
		return compte;
	}

	public void setCompte(ParametrageCompteInclusSms compte) {
		this.compte = compte;
	}

	public ParametrageInfosSolde(ParametrageCompteInclusSms compte) {
		super();
		this.compte = compte;
	}

	public ParametrageInfosSolde() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
