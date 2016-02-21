package org.adria.virementMultiple.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_TRANSFER",discriminatorType=DiscriminatorType.STRING,length=2)
@DiscriminatorValue(value="ST")
public class Transfer implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TRANSFERT_ID")
	private Long transfer_id;
	
	private Date creationDate ;
	private Date executionDate;
	private BigInteger balance;
	private String motif;


	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_NUMBER")
	private Account account;
	
//	@OneToOne(mappedBy="id")
//	private Subscriber subscriber;
	
	public Transfer(Date creationDate, Date executionDate, BigInteger balance, String motif) {
		super();
		this.creationDate = creationDate;
		this.executionDate = executionDate;
		this.balance = balance;
		this.motif = motif;
	}
	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}
	public BigInteger getBalance() {
		return balance;
	}
	public void setBalance(BigInteger balance) {
		this.balance = balance;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public Long getTransfer_id() {
		return transfer_id;
	}
	public void setTransfer_id(Long transfer_id) {
		this.transfer_id = transfer_id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
