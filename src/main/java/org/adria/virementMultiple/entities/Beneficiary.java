package org.adria.virementMultiple.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Beneficiary implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BENEFICIARY_ID")
	private Long beneficiaryId;
	
	private String firstName;
	private String lastName;
	private Integer accountNumber;
	
	
	@ManyToOne
	@JoinColumn(name="SUBSCRIBER_ID")
	private Subscriber subscriber;
	
	@JsonIgnore
	@OneToMany(mappedBy = "beneficiary")
	private Set<MultipleTransfersBeneficiary> mtb = new HashSet<MultipleTransfersBeneficiary>();
	

	public Beneficiary(String firstName, String lastName, Integer accountNumber,Subscriber subscriber
	) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.subscriber=subscriber;
	}

	public Beneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Set<MultipleTransfersBeneficiary> getMtb() {
		return mtb;
	}

	public void setMtb(Set<MultipleTransfersBeneficiary> mtb) {
		this.mtb = mtb;
	}
}
