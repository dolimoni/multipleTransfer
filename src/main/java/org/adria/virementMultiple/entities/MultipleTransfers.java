package org.adria.virementMultiple.entities;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("MT")
public class MultipleTransfers extends Transfer{
	
	private Integer BeneficiaryNumber;
	private String status;
	
	@OneToMany(mappedBy = "multipleTransfer")
	private Set<MultipleTransfersBeneficiary> mtb = new HashSet<MultipleTransfersBeneficiary>();
	
	public MultipleTransfers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MultipleTransfers(Date createdAt, Date executionDate, BigInteger balance, String motif) {
		super(createdAt, executionDate, balance, motif);
		// TODO Auto-generated constructor stub
	}
	
}
