package org.adria.virementMultiple.dto;

import java.math.BigInteger;
import java.util.Date;

public class MultipleTransferDTO {

	private String executionDate;
	private String motif;
	private String beneficiaryNumber;
	private BigInteger balancing;
	private String creationDate;
	private String accountNumber;
	private String beneficiariesBalancing;
	
	 public MultipleTransferDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MultipleTransferDTO(String executionDate, String motif, String beneficairyNumber, BigInteger balancing,
			String creationDate, String accountNumber) {
		super();
		this.executionDate = executionDate;
		this.motif = motif;
		this.beneficiaryNumber = beneficairyNumber;
		this.balancing = balancing;
		this.creationDate = creationDate;
		this.accountNumber = accountNumber;
	}
	public String getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getBeneficairyNumber() {
		return beneficiaryNumber;
	}
	public void setBeneficairyNumber(String beneficairyNumber) {
		this.beneficiaryNumber = beneficairyNumber;
	}
	public BigInteger getBalancing() {
		return balancing;
	}
	public void setBalancing(BigInteger balancing) {
		this.balancing = balancing;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBeneficiariesBalancing() {
		return beneficiariesBalancing;
	}
	public void setBeneficiariesBalancing(String beneficiariesBalancing) {
		this.beneficiariesBalancing = beneficiariesBalancing;
	}
}
