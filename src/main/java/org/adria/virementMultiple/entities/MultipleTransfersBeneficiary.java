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
    
    
	
}
