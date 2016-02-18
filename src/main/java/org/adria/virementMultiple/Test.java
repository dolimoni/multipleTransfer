package org.adria.virementMultiple;

public class Test {

	private String executionDate;
	private String motif;
	private String beneficiaryNumber;
	private String balancing;
	
	public Test() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getBeneficiaryNumber() {
		return beneficiaryNumber;
	}

	public void setBeneficiaryNumber(String beneficiaryNumber) {
		this.beneficiaryNumber = beneficiaryNumber;
	}

	public Test(String executionDate, String motif, String beneficiaryNumber, String balancing) {
		super();
		this.executionDate = executionDate;
		this.motif = motif;
		this.beneficiaryNumber = beneficiaryNumber;
		this.balancing = balancing;
	}

	public String getBalancing() {
		return balancing;
	}

	public void setBalancing(String balancing) {
		this.balancing = balancing;
	}
	
}
