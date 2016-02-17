package org.adria.virementMultiple.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ACCOUNT_NUMBER")
	private Long accountNumber;
	
	private String entitled;
	
	private BigInteger balancing;
	
	
	@ManyToOne
	@JoinColumn(name="SUBSCRIBER_ID")
	private Subscriber subscriber;

	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String entitled, BigInteger balancing) {
		super();
		this.entitled = entitled;
		this.balancing = balancing;
	}

	public String getEntitled() {
		return entitled;
	}

	public void setEntitled(String entitled) {
		this.entitled = entitled;
	}

	public BigInteger getBalancing() {
		return balancing;
	}

	public void setBalancing(BigInteger balancing) {
		this.balancing = balancing;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", entitled=" + entitled + ", balancing=" + balancing
				+ ", subscriber=" + subscriber + "]";
	}
	
	
}
