package org.adria.virementMultiple.dto;

import java.math.BigInteger;

public class MultipleTransferSearchDTO {
	
	private String status;
	private BigInteger minBalancing;
	private BigInteger maxBalancing;
	private String creationDate;
	private String accountNumber;
	
	public MultipleTransferSearchDTO() {
		// TODO Auto-generated constructor stub
	}
	public MultipleTransferSearchDTO(String status, BigInteger minBalancing, BigInteger maxBalancing, String creationDate,
			String accountNumber) {
		super();
		this.status = status;
		this.minBalancing = minBalancing;
		this.maxBalancing = maxBalancing;
		this.creationDate = creationDate;
		this.accountNumber = accountNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigInteger getMinBalancing() {
		return minBalancing;
	}
	public void setMinBalancing(BigInteger minBalancing) {
		this.minBalancing = minBalancing;
	}
	public BigInteger getMaxBalancing() {
		return maxBalancing;
	}
	public void setMaxBalancing(BigInteger maxBalancing) {
		this.maxBalancing = maxBalancing;
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
	

}
