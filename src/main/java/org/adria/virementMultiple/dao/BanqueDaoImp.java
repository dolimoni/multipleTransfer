package org.adria.virementMultiple.dao;

import java.util.List;

import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.Beneficiary;
import org.adria.virementMultiple.entities.MultipleTransfersBeneficiary;
import org.adria.virementMultiple.entities.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class BanqueDaoImp implements IBanqueDao{

	
	@Autowired
	SubscriberRepository sr;
	
	
	@Autowired
	AccountRepo ar;
	
	@Autowired
	BeneficiaryRepo br;
	
	
	
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

	

}
