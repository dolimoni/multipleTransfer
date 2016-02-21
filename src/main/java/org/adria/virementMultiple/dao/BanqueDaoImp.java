package org.adria.virementMultiple.dao;

import java.util.List;

import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.Beneficiary;
import org.adria.virementMultiple.entities.MultipleTransfers;
import org.adria.virementMultiple.entities.MultipleTransfersBeneficiary;
import org.adria.virementMultiple.entities.Subscriber;
import org.adria.virementMultiple.entities.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.adria.virementMultiple.dao.MutipleTransferRepo;;

@Component
@Transactional
public class BanqueDaoImp implements IBanqueDao{

	
	@Autowired
	SubscriberRepository sr;
	
	
	@Autowired
	AccountRepo ar;
	
	@Autowired
	BeneficiaryRepo br;
	
	
	@Autowired
	MutipleTransferRepo mt;
	
	@Autowired
	MultipleTransfersBeneficiaryRepo mtbr;
	
	@Autowired
	TransferRepo tr;
	
	@Override
	public Boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beneficiary> getBeneficiaries(Subscriber subscriber) {
		return br.findBySubscriber(subscriber);
	}

	@Override
	public Beneficiary getBeneficiaryById(Long id) {
		
		return br.findByBeneficiaryId(id);
	}

	@Override
	public List<Account> getAccountBySubscriber(Subscriber subscriber) {
			return ar.findBySubscriber(subscriber);
	}

	@Override
	public List<Account> getAccountBySubscriberId(Long id) {
		
		
		
		return ar.findByAccountNumber(id);
		
	  
	}

	@Override
	public Boolean Save(List<MultipleTransfersBeneficiary> mtb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Confirme(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subscriber findByUsername(String username) {
		return sr.findByUsername(username);
	}

	@Override
	public MultipleTransfers save(MultipleTransfers multipleTransfers) {
		
		return mt.saveAndFlush(multipleTransfers);
	}

	@Override
	public MultipleTransfers getMultipleTransfers(MultipleTransfers multipleTransfers) {
		
		return mtbr.findByMultipleTransfer(multipleTransfers);
	}

	@Override
	public MultipleTransfers getTransfer(Long id) {
		
		return mt.findOne(id);
	}

	@Override
	public Transfer addTransfer(Transfer transfer) {
		Transfer transfer2=tr.saveAndFlush(transfer);
		return transfer2;
	}

	@Override
	public MultipleTransfersBeneficiary addMultipleTranfersBeneficiary(
			MultipleTransfersBeneficiary multipleTransfersBeneficiary) {
		return mtbr.saveAndFlush(multipleTransfersBeneficiary);
		
	}

	@Override
	public List<MultipleTransfers> getTransfersByAccount(List<Account> accounts) {
		return tr.getByAccountIn(accounts);
	}
	
	

	

}
