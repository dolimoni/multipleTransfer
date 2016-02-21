package org.adria.virementMultiple.entities;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@DiscriminatorValue("MT")
public class MultipleTransfers extends Transfer{
	
	private Integer BeneficiaryNumber;
	private String status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "multipleTransfer")
	private List<MultipleTransfersBeneficiary> mtb ;
	
	public MultipleTransfers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MultipleTransfers(Date creationDate, Date executionDate, BigInteger balance, String motif,
			Integer beneficiaryNumber, String status) {
		super(creationDate, executionDate, balance, motif);
		BeneficiaryNumber = beneficiaryNumber;
		this.status = status;
	}

	public MultipleTransfers(Date createdAt, Date executionDate, BigInteger balance, String motif) {
		super(createdAt, executionDate, balance, motif);
		// TODO Auto-generated constructor stub
	}

	public Integer getBeneficiaryNumber() {
		return BeneficiaryNumber;
	}

	public void setBeneficiaryNumber(Integer beneficiaryNumber) {
		BeneficiaryNumber = beneficiaryNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<MultipleTransfersBeneficiary> getMtb() {
		return mtb;
	}

	public void setMtb(List<MultipleTransfersBeneficiary> mtb) {
		this.mtb = mtb;
	}

	@Override
	public String toString() {
		return "MultipleTransfers [BeneficiaryNumber=" + BeneficiaryNumber + ", status=" + status +", toString()=" + super.toString() + "]";
	}
	
}
