package org.adria.virementMultiple.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ParametrageMiniReleve {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	private ParametrageCompteInclusSms compte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ParametrageMiniReleve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParametrageMiniReleve(ParametrageCompteInclusSms compte) {
		super();
		this.compte = compte;
	}

	public Long getId_ParametrageMiniReleve() {
		return id;
	}

	public void setId_ParametrageMiniReleve(Long id_ParametrageMiniReleve) {
		this.id= id_ParametrageMiniReleve;
	}

	public ParametrageCompteInclusSms getCompte() {
		return compte;
	}

	public void setCompte(ParametrageCompteInclusSms compte) {
		this.compte = compte;
	}

}
