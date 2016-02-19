package org.adria.virementMultiple.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MultipleTransfersBeneficiary implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transfer_id")
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TRANSFERT_ID")   
	private MultipleTransfers multipleTransfer;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BENEFICIARY_ID")
	private Beneficiary beneficiary;
    private Long montant;     
	
	public MultipleTransfersBeneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MultipleTransfersBeneficiary(long id, MultipleTransfers multipleTransfer, Beneficiary beneficiary,
			Long montant) {
		super();
		this.id = id;
		this.multipleTransfer = multipleTransfer;
		this.beneficiary = beneficiary;
		this.montant = montant;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public MultipleTransfers getMultipleTransfer() {
		return multipleTransfer;
	}
	public void setMultipleTransfer(MultipleTransfers multipleTransfer) {
		this.multipleTransfer = multipleTransfer;
	}
	public Beneficiary getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}
	public Long getMontant() {
		return montant;
	}
	public void setMontant(Long montant) {
		this.montant = montant;
	}
    
    
	
}
