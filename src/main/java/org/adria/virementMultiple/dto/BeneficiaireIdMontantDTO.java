package org.adria.virementMultiple.dto;

import java.math.BigInteger;

public class BeneficiaireIdMontantDTO 
{
	private Long idBeneficiaire ; 
	private int montant ;
	
	
	public BeneficiaireIdMontantDTO(Long idBeneficiaire , int montant)
	{
		this.idBeneficiaire = idBeneficiaire ;
		this.montant = montant ;
	}
	
	public Long getIdBeneficiaire() {
		return idBeneficiaire;
	}
	public void setIdBeneficiaire(Long idBeneficiaire) {
		this.idBeneficiaire = idBeneficiaire;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	} 
	
}
